package com.example.java_angular_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Role {
    @Id
    private String roleName;
    private String roleDescription;

}
