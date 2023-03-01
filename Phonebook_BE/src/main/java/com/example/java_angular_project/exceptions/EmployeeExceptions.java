package com.example.java_angular_project.exceptions;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


public class EmployeeExceptions extends ResponseEntityExceptionHandler {
    public EmployeeExceptions(String message ){
        super();
    }
}
