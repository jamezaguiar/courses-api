package dev.jamersonaguiar.courses_api.modules.course.useCases;

import dev.jamersonaguiar.courses_api.modules.course.CourseEntity;
import dev.jamersonaguiar.courses_api.modules.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseUseCase {
    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity course) {
        return this.courseRepository.save(course);
    }

}
