package com.example.java_angular_project.repository;

import com.example.java_angular_project.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePagingRepo  extends PagingAndSortingRepository<Employee,Long> {

}
