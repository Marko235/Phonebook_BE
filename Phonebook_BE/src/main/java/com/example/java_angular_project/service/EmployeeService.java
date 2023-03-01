package com.example.java_angular_project.service;

import com.example.java_angular_project.model.DTOs.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

@Service
public interface EmployeeService {
    ResponseEntity<?> getAllEmployees(@RequestParam(defaultValue = "0") Integer pageNo,
                                      @RequestParam(defaultValue = "10") Integer pageSize,
                                      @RequestParam(defaultValue = "id") String sortBy);
    ResponseEntity<?> addNewEmployee(EmployeeDTO employeeDTO) throws ParseException;
    ResponseEntity<?> findEmployeeById(Long id);
    ResponseEntity<?> updateEmployeeById(Long id , EmployeeDTO employeeDTO);
    ResponseEntity<?> deleteEmployeeById(Long id);
}
