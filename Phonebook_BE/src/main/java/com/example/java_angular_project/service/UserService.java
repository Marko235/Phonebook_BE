package com.example.java_angular_project.service;

import com.example.java_angular_project.model.User;
import com.example.java_angular_project.model.DTOs.RegisterDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void initRoleAndUser();
    User registerNewUser(RegisterDTO registerDTO);
}
