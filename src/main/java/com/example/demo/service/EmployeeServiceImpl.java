package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        return optionalEmployee.orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public boolean remove(Long id){
        if(findById(id) != null){
            employeeRepo.deleteById(id);
            return true;
        }
        return false;


    }
}
