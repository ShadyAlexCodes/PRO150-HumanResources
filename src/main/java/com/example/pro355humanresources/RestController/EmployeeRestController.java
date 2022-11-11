package com.example.pro355humanresources.RestController;

import com.example.pro355humanresources.BusinessLogicLayer.EmployeeLogicLayer;
import com.example.pro355humanresources.Database.EmployeeRepo;
import com.example.pro355humanresources.Models.Address;
import com.example.pro355humanresources.Models.Employee;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeLogicLayer employeeLogicLayer;

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping(path="/employee" )
    public String getEmployees() throws IOException {
        return "List of All Employee's";
    }

    @PostMapping(path="/employee")
    public String addEmployee(@RequestBody Employee employee) throws IOException {
        employeeRepo.save(new Employee(employee.getEmployeeFirstName(), employee.getEmployeeLastName()));
        return "The employee " + employee.getEmployeeFirstName() + " has been created!";
    }

    @DeleteMapping(path="/employee")
    public String deleteAllEmployees() {
        employeeRepo.deleteAll();
        return "All employee's have been deleted.";
    }

    @PostMapping(path="/generateEmployees/{quantity}")
    public String generateFakeEmployees(@PathVariable int quantity) {

        Faker faker = new Faker();

        for(int i = 0; i < quantity; i++) {
            employeeRepo.save(new Employee(faker.name().firstName(), faker.name().lastName(), new Address(faker.address().streetAddressNumber(), faker.address().streetName(), faker.address().city(), faker.address().state(), faker.address().zipCode())));
        }

        return "Inserted a total of " + quantity + " employees into the database";
    }
}
