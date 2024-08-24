package com.stormbreaker.mark85.controller;

import com.stormbreaker.mark85.dto.Response;
import com.stormbreaker.mark85.entities.Employee;
import com.stormbreaker.mark85.requestbody.AddEmployeeRequestBody;
import com.stormbreaker.mark85.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getEmployees() {
        Response response = new Response();
        response.setStatus(HttpStatus.OK.value());
        response.setData(employeeService.getEmployees());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<?> saveEmployee(
            @Validated @RequestBody AddEmployeeRequestBody request
    ) {
        Employee addedEmployee = employeeService.createEmployee(request);
        return new ResponseEntity<>(addedEmployee, HttpStatus.CREATED);
    }
}
