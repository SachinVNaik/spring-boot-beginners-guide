package com.stormbreaker.mark85.services;

import com.stormbreaker.mark85.entities.Employee;
import com.stormbreaker.mark85.repositories.EmployeeRepository;
import com.stormbreaker.mark85.requestbody.AddEmployeeRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> getEmployee(Integer employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(AddEmployeeRequestBody request) {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName(request.getFirstName());
        newEmployee.setLastName(request.getLastName());
        newEmployee.setEmail(request.getEmail());
        return employeeRepository.save(newEmployee);
    }

    public List<Employee> saveEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }
}
