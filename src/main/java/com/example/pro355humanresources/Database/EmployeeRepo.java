package com.example.pro355humanresources.Database;

import com.example.pro355humanresources.Models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepo
    extends MongoRepository<Employee, String> {

    List<Employee> findAllByEmployeeFirstNameContaining(String employeeLastName);
    List<Employee> findAllByEmployeeLastNameContaining(String employeeLastName);
    List<Employee> findByEmployeeStatus(boolean enabled);
   // List<Employee> findByEmployeeFirstName(String employeeFirstName);
//    public Employee findByEmployeeId(String id);
//    public Employee findByEmployeeFirstName(String employeeFirstName);
}
