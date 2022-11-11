package com.example.pro355humanresources.Database;

import com.example.pro355humanresources.Models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo
    extends MongoRepository<Employee, Integer> {
}
