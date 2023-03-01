package com.example.java_angular_project.model.DTOs;

import com.example.java_angular_project.model.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeDTO {

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthday;
    @NonNull
    private String email;
    @NonNull
    private Long phoneNumber;
    @NonNull
    private Gender gender;
    private String addressLine;
    private String city;
    private String country;

}
