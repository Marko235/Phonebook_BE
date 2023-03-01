package com.example.java_angular_project.model.DTOs;

import com.example.java_angular_project.model.Role;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
public class RegisterDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
