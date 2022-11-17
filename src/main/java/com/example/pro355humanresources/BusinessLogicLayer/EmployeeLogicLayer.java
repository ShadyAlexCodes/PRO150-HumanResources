package com.example.pro355humanresources.BusinessLogicLayer;

import com.example.pro355humanresources.Database.EmployeeRepo;
import com.example.pro355humanresources.Models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeLogicLayer {
    private EmployeeRepo employeeRepo;

    public List<Employee> findAllEmployees() throws IOException {
        return employeeRepo.findAll();
    }

}
