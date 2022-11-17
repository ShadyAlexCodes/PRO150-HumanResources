package com.example.pro355humanresources.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.pro355humanresources.enties.Employee;
import com.example.pro355humanresources.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/ERC")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String OnlineConfirmation() {
        return service.EmployeeServiceConfirmation();
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    @RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
    public List<Employee> findAllEmployees() {
        return service.getAllEmployees();
    }

    @RequestMapping(value = "/getEmployeeById/{id}", method = RequestMethod.GET)
    public Employee findEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @RequestMapping(value = "/deleteEmployeeById/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployeeById(id);
    }

}