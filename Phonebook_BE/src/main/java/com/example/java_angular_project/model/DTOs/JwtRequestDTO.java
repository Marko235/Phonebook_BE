package com.example.java_angular_project.model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtRequestDTO {
    private String username;
    private String password;
}
