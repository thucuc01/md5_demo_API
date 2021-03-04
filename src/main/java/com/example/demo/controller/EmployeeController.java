package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Employee;
import com.example.demo.service.CityServiceImpl;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CityServiceImpl cityService;


    @GetMapping
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findbyId(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public void create(@PathVariable Long id,@RequestBody Employee employee) {
        City city= cityService.findById(id);
        employee.setCity(city);
        employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.remove(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Employee employee) {
        employeeService.save(employee);
    }
}
