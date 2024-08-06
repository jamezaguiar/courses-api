package dev.jamersonaguiar.courses_api.modules.course.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCourseRequestDTO {

    @NotBlank(message = "name is a mandatory field.")
    private String name;

    @NotBlank(message = "category is a mandatory field.")
    private String category;

    private Boolean isActive;

}
