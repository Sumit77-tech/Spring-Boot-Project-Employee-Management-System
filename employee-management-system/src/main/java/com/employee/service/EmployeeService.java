package com.employee.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.employee.model.Employee;

public interface EmployeeService {

    // Get all employees
    List<Employee> getAllEmployee();

    // Save an employee
    void save(Employee employee);

    // Get employee by ID
    Employee getById(Long id);

    // Delete employee by ID
    void deleteById(Long id);

    // Get all employees with pagination
    Page<Employee> getAllEmployeePage(Pageable pageable);

    // Search employees by name with pagination
    Page<Employee> searchEmployees(String name, Pageable pageable);
}
