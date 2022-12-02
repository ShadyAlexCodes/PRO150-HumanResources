package com.example.pro355humanresources.RestController;


import com.example.pro355humanresources.Database.EmployeeRepo;
import com.example.pro355humanresources.Models.Address;
import com.example.pro355humanresources.Models.Employee;
import com.github.javafaker.Faker;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());


    @Autowired
    private EmployeeRepo employeeRepo;

    /**
     * Returns a list of Employees.
     * The url allows for parameters to query firstName and lastName
     * <p>
     * This method will return JSON data and an HTTP Status
     *
     * @param   firstName       query by first name
     * @param   lastName        query by last name
     * @return                  results and http status
     * @throws  IOException
     */
    @GetMapping(path = "/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) throws IOException {
        LOG.info("Getting All Employees: ---");
        try {
            List<Employee> employees = new ArrayList<Employee>();

            if (firstName == null && lastName == null) employees.addAll(employeeRepo.findAll());
            else if (firstName != null) employees.addAll(employeeRepo.findAllByEmployeeFirstNameContaining(firstName));
            else employees.addAll(employeeRepo.findAllByEmployeeLastNameContaining(lastName));

            if (employees.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping(path = "/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id) throws IOException {
        LOG.info("Finding Employee by Id: ---");

        // Create an Employee (W/ Optional) and assign the found Id to that value
        Optional<Employee> employeeData = employeeRepo.findById(id);

        // Ensure they are present otherwise return not found
        return employeeData.map(employee -> new ResponseEntity<>(employee, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path="/employees/enabled")
    public ResponseEntity<List<Employee>> getEnabledEmployees() {
        LOG.info("Find Enabled Employees: ---");
        try {
            List<Employee> employees = employeeRepo.findByEmployeeStatus(true);

            if(employees.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(path = "/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) throws IOException {
        LOG.info("Creating a new Employee: ---");
        try {
            Employee newEmployee = employeeRepo.save(employee);
            return new ResponseEntity<>(newEmployee, HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/employees/{id}")
    public ResponseEntity<Employee> updateById(@PathVariable("id") String id, @RequestBody Employee employee) {
        Optional<Employee> employeeData = employeeRepo.findById(id);

        if(employeeData.isPresent()) {
            Employee updatedEmployee = employeeData.get();
            updatedEmployee.setEmployeeFirstName(employee.getEmployeeFirstName());
            updatedEmployee.setEmployeeLastName(employee.getEmployeeLastName());
            updatedEmployee.setEmployeeAddress(employee.getEmployeeAddress());
            updatedEmployee.setEmployeeSalary(employee.getEmployeeSalary());
            updatedEmployee.setEmployeePosition(employee.getEmployeePosition());
            updatedEmployee.setModifiedDate(LocalDateTime.now().toString());
            return new ResponseEntity<>(employeeRepo.save(updatedEmployee), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/employees")
    public ResponseEntity<HttpStatus> deleteAllEmployees() {
        LOG.warn("ALL EMPLOYEES HAVE BEEN DELETED");
        try {
            employeeRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/employees/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") String id) {
        LOG.warn("ALL EMPLOYEES HAVE BEEN DELETED");
        try {
            employeeRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/employees/generate/{quantity}")
    public ResponseEntity<HttpStatus> generateFakeEmployees(@PathVariable int quantity) {
        LOG.info("Creating " + quantity + " of users!");
        try {
            Faker faker = new Faker();

            for (int i = 0; i < quantity; i++) {
                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();
                double salary = faker.number().randomDouble(2, 10, 400000);
                String email = faker.internet().emailAddress();
                String position = faker.job().position();
                String address = faker.name().firstName();
                boolean status = faker.bool().bool();

               createEmployee(new Employee(
                       firstName,
                       lastName,
                       salary,
                       email,
                       position,
                       new Address(faker.address().streetAddressNumber(), faker.address().streetName(), faker.address().city(), faker.address().state(), faker.address().zipCode()),
                       status));
            }
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }
}
