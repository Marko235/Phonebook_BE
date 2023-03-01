package com.example.java_angular_project.controller;

import com.example.java_angular_project.model.DTOs.EmployeeDTO;
import com.example.java_angular_project.repository.EmployeePagingRepo;
import com.example.java_angular_project.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeePagingRepo pagingRepo;

    @PreAuthorize("hasAnyRole('User','Admin')")
    @GetMapping(value = "/employees")
    public ResponseEntity<?> renderEmployees(@RequestParam(defaultValue = "0") Integer pageNo,
                                             @RequestParam(defaultValue = "10") Integer pageSize,
                                             @RequestParam(defaultValue = "id") String sortBy) {
        return employeeService.getAllEmployees(pageNo,pageSize,sortBy);

    }

    @PreAuthorize("hasRole('Admin')")
    @PostMapping(value = "/employee")
    public ResponseEntity<?> addAnEmployee(
        @RequestBody EmployeeDTO employeeDTO
    ) throws ParseException {
        return employeeService.addNewEmployee(employeeDTO);
    }

    @PreAuthorize("hasAnyRole('User','Admin')")
    @GetMapping(value = "/employee/{id}")
    public ResponseEntity<?> renderAnEmployee(@PathVariable("id") Long id) {
        return employeeService.findEmployeeById(id);
    }

    @PreAuthorize("hasRole('Admin')")
    @PutMapping(value = "/employee/{id}")
    public ResponseEntity<?> updateAnEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployeeById(id, employeeDTO);
    }

    @PreAuthorize("hasRole('Admin')")
    @DeleteMapping(value = "/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        return employeeService.deleteEmployeeById(id);
    }
}



