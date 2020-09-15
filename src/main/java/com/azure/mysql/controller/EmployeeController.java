package com.azure.mysql.controller;

import com.azure.mysql.entity.Employee;
import com.azure.mysql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.transaction.Transactional;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping(value = "/employee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public Employee createEmployee(@RequestBody Employee employee) {
        Employee emp = employeeRepository.save(employee);
        return emp;
    }

    @GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployee(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @DeleteMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}
