package dev.jamersonaguiar.courses_api.modules.course.useCases;

import dev.jamersonaguiar.courses_api.exceptions.CourseNotFoundException;
import dev.jamersonaguiar.courses_api.modules.course.CourseEntity;
import dev.jamersonaguiar.courses_api.modules.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ToggleActiveCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID courseId) {
        var course = this.courseRepository.findById(courseId).orElseThrow(CourseNotFoundException::new);

        course.setIsActive(!course.getIsActive());

        return this.courseRepository.save(course);
    }
}
