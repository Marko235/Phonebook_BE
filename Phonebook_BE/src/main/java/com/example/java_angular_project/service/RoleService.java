package com.example.java_angular_project.service;

import com.example.java_angular_project.model.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    Role createNewRole(Role role);
}
