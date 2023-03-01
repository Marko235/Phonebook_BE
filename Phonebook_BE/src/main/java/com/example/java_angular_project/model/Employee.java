package com.example.java_angular_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String email;
    private Long phoneNumber;
    private Gender gender;
    private String addressLine;
    private String city;
    private  String country;

    public Employee(String firstName, String lastName, LocalDate birthday, String email, Long phoneNumber, Gender gender, String addressLine, String city, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.addressLine = addressLine;
        this.city = city;
        this.country = country;
    }
}
