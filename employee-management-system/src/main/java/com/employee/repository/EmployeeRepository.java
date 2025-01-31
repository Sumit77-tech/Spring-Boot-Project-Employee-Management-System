package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find employees by name with pagination support
    Page<Employee> findByNameContainingIgnoreCase(String name, Pageable pageable);

    // You can add more custom queries here if needed, such as finding by email or
    // other fields
    Employee findByEmail(String email); // Example: Find an employee by their email
}
