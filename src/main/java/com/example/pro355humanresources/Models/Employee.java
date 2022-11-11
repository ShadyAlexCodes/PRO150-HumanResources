package com.example.pro355humanresources.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "Employees")
public class Employee {

    private String employeeFirstName;
    private String employeeLastName;
    private String employeeEmail;
    private int employeeSSN;
    private double employeeSalary;
    private boolean employeeStatus;
    private String createdDate;
    private String modifiedDate;
    private Address employeeAddress;

    public Employee() {
    }

    public Employee(String employeeFirstName, String employeeLastName) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.createdDate = LocalDateTime.now().toString();
    }

    public Employee(String employeeFirstName, String employeeLastName, Address employeeAddress) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeAddress = employeeAddress;
        this.createdDate = LocalDateTime.now().toString();
    }

    public Employee(String employeeFirstName, String employeeLastName, String employeeEmail, int employeeSSN, double employeeSalary, boolean employeeStatus, Address employeeAddress) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeEmail = employeeEmail;
        this.employeeSSN = employeeSSN;
        this.employeeSalary = employeeSalary;
        this.employeeStatus = employeeStatus;
        //this.employeeAddress = employeeAddress;
        this.createdDate = LocalDateTime.now().toString();
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public int getEmployeeSSN() {
        return employeeSSN;
    }

    public void setEmployeeSSN(int employeeSSN) {
        this.employeeSSN = employeeSSN;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public boolean isEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(boolean employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


    @Override
    public String toString() {
        return "Employee{ employeeFirstName='" + employeeFirstName + '\'' + ", employeeLastName='" + employeeLastName + '\'' + ", employeeEmail='" + employeeEmail + '\'' + ", employeeSSN=" + employeeSSN + ", employeeSalary=" + employeeSalary + ", employeeStatus=" + employeeStatus + ", createdDate='" + createdDate + '\'' + ", modifiedDate='" + modifiedDate + '\'' + '}';
    }
}
