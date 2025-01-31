package com.employee.service;

import com.employee.model.Department;
import java.util.List; // Import this

public interface DepartmentService {
    void save(Department department);

    Department getById(Long id);

    void deleteById(Long id);

    List<Department> getAllDepartments(); // Now List is recognized
}
