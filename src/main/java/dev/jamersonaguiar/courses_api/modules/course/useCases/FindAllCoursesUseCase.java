package dev.jamersonaguiar.courses_api.modules.course.useCases;

import dev.jamersonaguiar.courses_api.modules.course.CourseEntity;
import dev.jamersonaguiar.courses_api.modules.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllCoursesUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute() {
        return courseRepository.findAll();
    }
}
