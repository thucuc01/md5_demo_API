package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee oder);

    boolean remove(Long id);
    List<Employee> findAll(int page, int size);
}
