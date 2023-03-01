package com.example.java_angular_project.service.Implementation;

import com.example.java_angular_project.model.Role;
import com.example.java_angular_project.repository.RoleRepository;
import com.example.java_angular_project.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@RequiredArgsConstructor
public class RoleServiceImplementation implements RoleService {
    private final RoleRepository roleRepository;
    public Role createNewRole(Role role) {
        return roleRepository.save(role);
    }

}
