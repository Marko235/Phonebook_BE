package com.example.java_angular_project.service.Implementation;

import com.example.java_angular_project.model.User;
import com.example.java_angular_project.model.DTOs.RegisterDTO;
import com.example.java_angular_project.model.Role;
import com.example.java_angular_project.repository.AppUserRepository;
import com.example.java_angular_project.repository.RoleRepository;
import com.example.java_angular_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;




    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleRepository.save(userRole);

    }

    @Override
    public User registerNewUser(RegisterDTO registerDTO) {
            Role role = roleRepository.findById("Admin").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        User user = new User(registerDTO.getUsername(),registerDTO.getFirstName(),registerDTO.getLastName() ,
            registerDTO.getEmail(), passwordEncoder.encode(registerDTO.getPassword()),userRoles);
        return appUserRepository.save(user) ;
    }
}
