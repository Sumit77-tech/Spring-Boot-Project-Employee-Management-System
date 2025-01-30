package com.employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    private int age; // Changed from String to int
    private String designation;

    // Default Constructor (Required by JPA)
    public Employee() {
    }

    // Parameterized Constructor (Optional, for convenience)
    public Employee(String name, String email, int age, String designation) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.designation = designation;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() { // Changed return type to int
        return age;
    }

    public void setAge(int age) { // Changed parameter type to int
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", designation="
                + designation + "]";
    }
}
