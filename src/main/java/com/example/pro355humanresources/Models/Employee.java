package com.example.pro355humanresources.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;


@Document(collection = "Employees")
public class Employee {

    @Id
    private String id;
    private String employeeFirstName;
    private String employeeLastName;
    private double employeeSalary;
    private String employeeEmail;
    private String employeeTeam;
    private Address employeeAddress;
    private boolean employeeStatus;
    private String createdDate;
    private String modifiedDate;

    public Employee() {
    }

    public Employee(String employeeFirstName, String employeeLastName) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeStatus = true;
        this.createdDate = LocalDateTime.now().toString();
    }

    // private String[] positions;

    public Employee(String employeeFirstName, String employeeLastName, Address employeeAddress) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeAddress = employeeAddress;
        this.createdDate = LocalDateTime.now().toString();
    }

    public Employee(String id, String employeeFirstName, String employeeLastName, double employeeSalary, Address employeeAddress, String employeeTeam, boolean employeeStatus) {
        this.id = id;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeSalary = employeeSalary;
        this.employeeTeam = employeeTeam;
        this.employeeAddress = employeeAddress;
        this.employeeStatus = employeeStatus;
        this.createdDate = LocalDateTime.now().toString();
        this.modifiedDate = "Never";
    }

    public Employee(String employeeFirstName, String employeeLastName, double employeeSalary, String employeeEmail, String employeeTeam, Address employeeAddress, boolean employeeStatus) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeSalary = employeeSalary;
        this.employeeEmail = employeeEmail;
        this.employeeTeam = employeeTeam;
        this.employeeAddress = employeeAddress;
        this.employeeStatus = employeeStatus;
        this.createdDate = LocalDateTime.now().toString();
        this.modifiedDate = "Never";
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeTeam() {
        return employeeTeam;
    }

    public void setEmployeeTeam(String employeeTeam) {
        this.employeeTeam = employeeTeam;
    }

    public boolean isEmployeeStatus() {
        return employeeStatus;
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

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Address getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(Address employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public boolean getEmployeeStatus() {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeFirstName='" + employeeFirstName + '\'' + ", employeeLastName='" + employeeLastName + '\'' + ", employeeSalary=" + employeeSalary + ", employeePosition='" + employeeTeam + '\'' + ", employeeAddress=" + employeeAddress + ", employeeStatus=" + employeeStatus + ", createdDate='" + createdDate + '\'' + ", modifiedDate='" + modifiedDate + '\'' + '}';
    }
}
