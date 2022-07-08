package com.example.spring01.controller;

import com.example.spring01.model.Employee;
import com.example.spring01.model.api.EmployeeCreateRequest;
import com.example.spring01.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeCreateRequest request) {
        employeeService.createEmployee(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
