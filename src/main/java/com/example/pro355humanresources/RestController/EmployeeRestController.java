package com.example.pro355humanresources.RestController;

import com.example.pro355humanresources.BusinessLogicLayer.EmployeeLogicLayer;
import com.example.pro355humanresources.Models.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeLogicLayer employeeLogicLayer;

    @GetMapping(path="/employees")
    public List<Employee> findAllEmployees() throws IOException {
        return employeeLogicLayer.findAllEmployees();
    }

    @GetMapping(path="/test")
    public String employeeRoute() throws IOException {
        return "My path was hit!";
    }

}
