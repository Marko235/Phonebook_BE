package com.example.java_angular_project.model.DTOs;

import com.example.java_angular_project.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class JwtResponseDTO {
    private User user;
    private String token;
}
