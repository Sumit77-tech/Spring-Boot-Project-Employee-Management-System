package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import com.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    // Display home page with all employees, including pagination and search
    // functionality
    @GetMapping("/")
    public String viewHomePage(Model model,
            @RequestParam(value = "query", required = false) String query,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size) {

        Page<Employee> employeePage;

        // Apply search functionality if a query is provided
        if (query != null && !query.isEmpty()) {
            employeePage = employeeService.searchEmployees(query, PageRequest.of(page, size));
        } else {
            employeePage = employeeService.getAllEmployeePage(PageRequest.of(page, size));
        }

        // Add attributes to the model
        model.addAttribute("employeePage", employeePage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", employeePage.getTotalPages());
        model.addAttribute("size", size);
        model.addAttribute("query", query);

        return "index"; // Ensure 'index.html' exists
    }

    // Show form to add a new employee
    @GetMapping("/add")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("employee", employee);
        return "addEmployee";
    }

    // Save the new employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        if (employee.getDepartment() != null) {
            employeeService.save(employee);
        } else {
            System.out.println("Department not selected for the employee");
        }
        return "redirect:/";
    }

    // Show the update form for an employee
    @GetMapping("/updateform/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        Employee employee = employeeService.getById(id);
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("employee", employee);
        return "update"; // Ensure 'update.html' exists
    }

    // Update the employee (Now using POST with employee ID in the form)
    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        Employee existingEmployee = employeeService.getById(employee.getId());

        // Update employee details
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setDesignation(employee.getDesignation());

        // Ensure department is properly assigned
        if (employee.getDepartment() != null) {
            existingEmployee.setDepartment(employee.getDepartment());
        }

        employeeService.save(existingEmployee); // Save updated employee

        return "redirect:/"; // Redirect to home page
    }

    // Delete an employee by ID
    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") long id) {
        employeeService.deleteById(id);
        return "redirect:/";
    }

}
