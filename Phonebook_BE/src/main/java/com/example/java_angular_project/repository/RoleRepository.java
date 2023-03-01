package com.example.java_angular_project.repository;

import com.example.java_angular_project.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository <Role,String> {
}
