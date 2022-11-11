package com.example.pro355humanresources.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ERC")
public class EmployeeRestController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String OnlineConfirmation() {
        return "Employee Rest Controller Online";
    }
}