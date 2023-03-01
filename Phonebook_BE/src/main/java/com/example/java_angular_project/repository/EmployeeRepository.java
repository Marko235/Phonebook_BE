package com.example.java_angular_project.repository;

import com.example.java_angular_project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    boolean existsById(Long id);
    void deleteById(Long id);

}
