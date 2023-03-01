package com.example.java_angular_project.controller;

import com.example.java_angular_project.model.DTOs.JwtRequestDTO;
import com.example.java_angular_project.model.DTOs.JwtResponseDTO;
import com.example.java_angular_project.model.User;
import com.example.java_angular_project.model.DTOs.RegisterDTO;
import com.example.java_angular_project.model.Role;
import com.example.java_angular_project.service.Implementation.JwtService;
import com.example.java_angular_project.service.RoleService;
import com.example.java_angular_project.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1")
public class UserController {
    private final RoleService roleService;
    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("/role")
   public Role createNewRole(@RequestBody Role role) {
       return roleService.createNewRole(role);
    }
   @PostConstruct
   public void initRoleAndUser() {
       userService.initRoleAndUser();
   }
   @PostMapping("/register")
    public User registerNewUser(@RequestBody RegisterDTO registerDTO){
        return userService.registerNewUser(registerDTO);
   }
   @PostMapping("/authenticate")
    public JwtResponseDTO authenticate(@RequestBody JwtRequestDTO jwtRequestDTO) throws Exception {
        return jwtService.createJwtToken(jwtRequestDTO);
   }
}
