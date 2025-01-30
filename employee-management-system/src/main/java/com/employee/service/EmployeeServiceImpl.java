package com.employee.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        if (Objects.nonNull(employee)) {
            employeeRepository.save(employee);
        }
    }

    @Override
    public Employee getById(Long id) {
        Employee employee = null;
        if (Objects.nonNull(id)) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(id);
            if (optionalEmployee.isPresent()) {
                employee = optionalEmployee.get();
            } else {
                throw new RuntimeException("Employee not found with the id:" + id);
            }
        }
        return employee;
    }

    @Override
    public void deleteById(Long id) {
        if (Objects.nonNull(id)) {
            employeeRepository.deleteById(id);
        }
    }

    // New method for search functionality
    public List<Employee> searchEmployees(String name) {
        if (Objects.nonNull(name) && !name.isEmpty()) {
            return employeeRepository.findByNameContainingIgnoreCase(name);
        }
        return getAllEmployee(); // Return all employees if no search term is provided
    }
}
