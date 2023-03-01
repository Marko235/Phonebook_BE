package com.example.java_angular_project.model.DTOs;

import com.example.java_angular_project.exceptions.EmployeeExceptions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessageDTO extends EmployeeExceptions {
    private String message ;

    public ErrorMessageDTO(String message) {
        super(message);
    }
}
