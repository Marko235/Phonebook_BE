package com.example.java_angular_project.service.Implementation;

import com.example.java_angular_project.exceptions.EmployeeExceptions;
import com.example.java_angular_project.model.DTOs.EmployeeDTO;
import com.example.java_angular_project.model.DTOs.ErrorMessageDTO;
import com.example.java_angular_project.model.DTOs.MessageDTO;
import com.example.java_angular_project.model.Employee;
import com.example.java_angular_project.repository.EmployeePagingRepo;
import com.example.java_angular_project.repository.EmployeeRepository;
import com.example.java_angular_project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeePagingRepo pagingRepo;

    @Autowired
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository, EmployeePagingRepo pagingRepo) {
        this.employeeRepository = employeeRepository;
        this.pagingRepo = pagingRepo;
    }

    @Override
    public ResponseEntity<?> getAllEmployees(@RequestParam(defaultValue = "0") Integer pageNo,
                                                          @RequestParam(defaultValue = "10") Integer pageSize,
                                                          @RequestParam(defaultValue = "id") String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Employee> pagedByParams = pagingRepo.findAll(paging);
        if (!pagedByParams.hasContent()) {
            return ResponseEntity.status(404).body("Here should go exception /employee list is empty");
        }

        return ResponseEntity.ok().body(pagedByParams.getContent());
    }

    @Override
    public ResponseEntity<?> addNewEmployee(EmployeeDTO employeeDTO) throws ParseException {
        if (employeeDTO.getFirstName().isEmpty() || employeeDTO.getLastName().isEmpty() || employeeDTO.getEmail().isEmpty()) {
            return ResponseEntity.status(401).body(new ErrorMessageDTO("Invalid input. Name or email missing"));
        }
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate birthday = employeeDTO.getBirthday();
        Date date = Date.from(birthday.atStartOfDay(defaultZoneId).toInstant()) ;
         LocalDateTime birthdayValidation = LocalDateTime.now().minusYears(15L);
         Date dateValidation = Date.from(birthdayValidation.atZone(ZoneId.systemDefault()).toInstant());
        if (!date.before(dateValidation) ) {
            return ResponseEntity.status(404).body(new ErrorMessageDTO("Employee is not old enough to work"));
        }
        Employee employee = new Employee(employeeDTO.getFirstName(),employeeDTO.getLastName(), employeeDTO.getBirthday(),
            employeeDTO.getEmail(), employeeDTO.getPhoneNumber(), employeeDTO.getGender(), employeeDTO.getAddressLine(),
            employeeDTO.getCity(), employeeDTO.getCountry());

        employeeRepository.save(employee);
        return ResponseEntity.ok().body(employee);
    }

    @Override
    public ResponseEntity<?> findEmployeeById(Long id) {
        if (!employeeRepository.existsById(id)) {
            return ResponseEntity.status(404).body(new ErrorMessageDTO("Employee with such id does not exist !"));
        }
        return ResponseEntity.ok().body(employeeRepository.findById(id));
    }

    @Override
    public ResponseEntity<?> updateEmployeeById(Long id, EmployeeDTO employeeDTO) {
        Employee employeeToBeUpdated;
        try {
            employeeToBeUpdated = employeeRepository.findById(id).get();
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ErrorMessageDTO("Employee with such id was not found"));
        }
            employeeToBeUpdated.setFirstName(employeeToBeUpdated.getFirstName());
        employeeToBeUpdated.setFirstName(employeeDTO.getFirstName());
        employeeToBeUpdated.setLastName(employeeDTO.getLastName());
        employeeToBeUpdated.setEmail(employeeDTO.getEmail());
        employeeToBeUpdated.setPhoneNumber(employeeDTO.getPhoneNumber());
        employeeToBeUpdated.setCity(employeeDTO.getCity());
        employeeToBeUpdated.setCountry(employeeDTO.getCountry());
        employeeToBeUpdated.setAddressLine(employeeDTO.getAddressLine());
        employeeToBeUpdated.setGender(employeeDTO.getGender());
        employeeToBeUpdated.setId(id);
        employeeRepository.save(employeeToBeUpdated);
        return ResponseEntity.ok().body(new MessageDTO("employee with id " + id + " have been successfully updated "));
    }

    @Override
    public ResponseEntity<?> deleteEmployeeById (Long id){
        try {
            employeeRepository.findById(id).get();
        }catch (Exception e){
            new EmployeeExceptions("User with such id does not exist");
        }
        employeeRepository.deleteById(id);
        return ResponseEntity.ok().body(new MessageDTO("User with id " + id + " has been successfully deleted"));
    }
}
