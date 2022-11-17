package com.example.pro355humanresources.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.pro355humanresources.enties.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
    Employee findByEmployeeLName(String employeeName);
}

