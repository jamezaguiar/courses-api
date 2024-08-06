package dev.jamersonaguiar.courses_api.modules.course.repositories;

import dev.jamersonaguiar.courses_api.modules.course.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
}
