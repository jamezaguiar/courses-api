package dev.jamersonaguiar.courses_api.modules.course.useCases;

import dev.jamersonaguiar.courses_api.exceptions.CourseNotFoundException;
import dev.jamersonaguiar.courses_api.modules.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public void execute(UUID courseId) {
        this.courseRepository.findById(courseId).orElseThrow(CourseNotFoundException::new);
        this.courseRepository.deleteById(courseId);
    }
}
