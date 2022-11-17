package com.example.pro355humanresources.RestController;

import com.example.pro355humanresources.BusinessLogicLayer.EmployeeLogicLayer;
import com.example.pro355humanresources.Database.EmployeeRepo;
import com.example.pro355humanresources.Models.Address;
import com.example.pro355humanresources.Models.Employee;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final EmployeeLogicLayer employeeLogicLayer = new EmployeeLogicLayer();

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping(path = "/employees")
    public List<Employee> getAllEmployees() throws IOException {
        LOG.info("Getting all employees");
        return employeeRepo.findAll();
    }

    @PostMapping(path = "/employees")
    public String addEmployee(@RequestBody Employee employee) throws IOException {
        LOG.info("Inserted the employee: " + employee);
        employeeRepo.save(new Employee(employee.getEmployeeFirstName(), employee.getEmployeeLastName(), employee.getEmployeeAddress()));
        return "The employee " + employee.getEmployeeFirstName() + " has been created!";
    }
    @PostMapping(path = "/employees/{id}")
    public String updateById(@PathVariable("id") Employee id){
//        employeeRepo.s
        return "";
    }

    @DeleteMapping(path = "/employees")
    public String deleteAllEmployees() {
        LOG.warn("ALL EMPLOYEES HAVE BEEN DELETED");
        employeeRepo.deleteAll();
        return "All employee's have been deleted.";
    }

    @DeleteMapping(path = "/employees/{id}")
    public String deleteById(@PathVariable("id") Employee id) {
        employeeRepo.delete(id);
        return "HAHAH U SMELL";
    }

    @PostMapping(path = "/employees/generate/{quantity}")
    public String generateFakeEmployees(@PathVariable int quantity) {

        Faker faker = new Faker();

        for (int i = 0; i < quantity; i++) {
            employeeRepo.save(new Employee(faker.name().firstName(), faker.name().lastName(), new Address(faker.address().streetAddressNumber(), faker.address().streetName(), faker.address().city(), faker.address().state(), faker.address().zipCode())));
        }

        return "Inserted a total of " + quantity + " employees into the database";
    }
}
