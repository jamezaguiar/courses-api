package dev.jamersonaguiar.courses_api.modules.course.controllers;

import dev.jamersonaguiar.courses_api.exceptions.CourseNotFoundException;
import dev.jamersonaguiar.courses_api.modules.course.CourseEntity;
import dev.jamersonaguiar.courses_api.modules.course.dto.CreateCourseRequestDTO;
import dev.jamersonaguiar.courses_api.modules.course.dto.UpdateCourseRequestDTO;
import dev.jamersonaguiar.courses_api.modules.course.useCases.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private FindAllCoursesUseCase findAllCoursesUseCase;

    @Autowired
    private UpdateCourseUseCase updateCourseUseCase;

    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;

    @Autowired
    private ToggleActiveCourseUseCase toggleActiveCourseUseCase;


    @PostMapping
    public CourseEntity create(@Valid @RequestBody CreateCourseRequestDTO createCourseRequestDTO) {
        var courseEntity = CourseEntity.builder()
                .name(createCourseRequestDTO.getName())
                .category(createCourseRequestDTO.getCategory())
                .isActive(createCourseRequestDTO.getIsActive())
                .build();

        return this.createCourseUseCase.execute(courseEntity);
    }

    @GetMapping
    public List<CourseEntity> listAll() {
        return this.findAllCoursesUseCase.execute();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @Valid @RequestBody UpdateCourseRequestDTO updateCourseRequestDTO) {
        try {
            var updatedCourse = this.updateCourseUseCase.execute(id, updateCourseRequestDTO.getName(), updateCourseRequestDTO.getCategory());
            return ResponseEntity.ok().body(updatedCourse);
        } catch (CourseNotFoundException e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        try {
            this.deleteCourseUseCase.execute(id);
            return ResponseEntity.noContent().build();
        } catch (CourseNotFoundException e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> toggleActive(@PathVariable UUID id) {
        try {
            var updatedCourse = this.toggleActiveCourseUseCase.execute(id);
            return ResponseEntity.ok().body(updatedCourse);
        } catch (CourseNotFoundException e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }
}
