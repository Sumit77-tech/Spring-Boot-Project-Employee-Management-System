package com.employee.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
            if (employee.getDepartment() == null) {
                System.out.println("Department is null for employee: " + employee.getName());
            } else {
                System.out.println("Saving employee: " + employee.getName() + " with department: "
                        + employee.getDepartment().getName());
            }
            employeeRepository.save(employee);
        } else {
            System.out.println("Employee is null.");
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

    // New method for search functionality with pagination and sorting
    @Override
    public Page<Employee> searchEmployees(String name, Pageable pageable) {
        if (Objects.nonNull(name) && !name.isEmpty()) {
            return employeeRepository.findByNameContainingIgnoreCase(name, pageable);
        }
        return employeeRepository.findAll(pageable); // Return all employees with pagination if no search term is
                                                     // provided
    }

    // Add pagination and sorting method for fetching all employees
    @Override
    public Page<Employee> getAllEmployeePage(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
}
