package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Display home page with all employees
    @GetMapping("/")
    public String viewHomePage(Model model, @RequestParam(value = "query", required = false) String query) {
        if (query != null && !query.isEmpty()) {
            List<Employee> employees = employeeService.searchEmployees(query);
            model.addAttribute("allemplist", employees);
        } else {
            model.addAttribute("allemplist", employeeService.getAllEmployee());
        }
        return "index"; // Ensure the 'index.html' template exists
    }

    // Show form to add a new employee
    @GetMapping("/add")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee(); // Create a new Employee object
        model.addAttribute("employee", employee); // Add it to the model
        return "addEmployee"; // Ensure the 'addEmployee.html' template exists
    }

    // Save the new employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee); // Save the employee
        return "redirect:/"; // Redirect to the home page
    }

    // Show the update form for a specific employee
    @GetMapping("/updateform/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeService.getById(id); // Fetch employee by ID
        model.addAttribute("employee", employee); // Add it to the model
        return "update"; // Ensure the 'update.html' template exists
    }

    // Delete an employee by ID
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") long id) {
        employeeService.deleteById(id); // Delete the employee
        return "redirect:/"; // Redirect to the home page
    }
}
