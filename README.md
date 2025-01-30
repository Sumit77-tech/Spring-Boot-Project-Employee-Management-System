# Spring-Boot-Project-Employee-Management-System

# Overview

# The Employee Management System is a web-based application built using Spring Boot that allows users to manage employees effectively. It includes features like adding, updating, deleting, searching, and paginating employee records. The system also supports department management and role-based authentication.

# Features

## Employee Management: Add, update, delete, and view employee details.

## Department Management: Associate employees with different departments.

## Search Employees: Search employees by name.

## Pagination & Sorting: Display employees with pagination and sorting options.

## Profile Details: View detailed employee information.

## REST API Endpoints: Expose API endpoints for integration.

# Technologies Used

## Backend: Spring Boot, Spring Data JPA, Spring Data Security

## Frontend: Thymeleaf, Bootstrap

## Database: MySQL

## Tools: Spring Boot DevTools, Lombok, Postman (for API testing)

# Installation & Setup Instructions

## Prerequisites

## Install Java 23(Latest Version)

## Install MySQL

## Install Maven

## Install Spring Boot

# Clone the Repository

## https://github.com/Sumit77-tech/Spring-Boot-Project-Employee-Management-System.git

# cd employee-management-system

# Set Up MySQL Database

## CREATE DATABASE employeemanagementsystem;

## USE employeemanagementsystem;

# Configure application.properties

## spring.datasource.url=jdbc:mysql://localhost:3306/employeemanagementsystem
## spring.datasource.username=root
## spring.datasource.password=W7301@jqir#
## spring.jpa.hibernate.ddl-auto=update
## spring.jpa.show-sql=true
## spring.jpa.properties.hibernate.format_sql=true

# Run the Application

## mvn spring-boot:run

# Access the Application

## Open http://localhost:8080/ in a browser.

# API Endpoints

! Method         ! Endpoint          ! Description
|-----------------|---------------|-----------------------|
! GET            ! /employees        ! View all employees
! POST           ! /employees        ! Add a new employee
! PUT            ! /employees/{id}   ! Update an employee
! DELETE         ! /employees/{id}   ! Delete an employee

# Troubleshooting

## Database Connection Issues: Ensure MySQL is running and credentials are correct.

## Pagination Errors: Validate page number and size parameters in the URL.

# Future Enhancements

## Add admin dashboard with detailed analytics

## Implement RESTful API for frontend integration

## Enhance UI with React or Angular
