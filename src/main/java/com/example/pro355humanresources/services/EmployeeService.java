package com.example.pro355humanresources.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pro355humanresources.enties.Employee;
import com.example.pro355humanresources.repos.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public String EmployeeServiceConfirmation(){
        return "EmployeeService is online";
    }
    public Employee saveEmployee (Employee employee){
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(int id){
        return repository.findById(id).orElse(null);
    }

    public String deleteEmployeeById(int id){
        repository.deleteById(id);
        return "Employee with id#" + id + " is removed\n";
    }
}
