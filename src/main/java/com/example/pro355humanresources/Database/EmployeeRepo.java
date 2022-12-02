package com.example.pro355humanresources.Database;

import com.example.pro355humanresources.Models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepo
    extends MongoRepository<Employee, String> {

    List<Employee> findAllByEmployeeFirstNameContainingIgnoreCase(String employeeLastName);
    List<Employee> findAllByEmployeeLastNameContainingIgnoreCase(String employeeLastName);
    List<Employee> findByEmployeeStatus(boolean enabled);

}
