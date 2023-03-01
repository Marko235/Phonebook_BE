package com.example.java_angular_project.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String username;
    @ManyToMany
    private Set<Role> roles;
    public User(String username , String firstName, String lastName, String email, String password, Set<Role> roles ){
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.roles = roles;
    this.username = username;
    }
}
