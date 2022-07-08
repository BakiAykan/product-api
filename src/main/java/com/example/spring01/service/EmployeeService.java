package com.example.spring01.service;

import com.example.spring01.model.Employee;
import com.example.spring01.model.api.EmployeeCreateRequest;
import com.example.spring01.model.exceptions.NotFoundException;
import com.example.spring01.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        }
        throw new NotFoundException("Employee not found by id: " + id);
    }

    public void createEmployee(EmployeeCreateRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employeeRepository.save(employee);
    }

    public List<Employee> getEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }
}
