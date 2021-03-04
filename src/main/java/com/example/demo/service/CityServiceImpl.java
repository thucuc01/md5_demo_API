package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.model.Employee;
import com.example.demo.repo.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityServiceImpl {
    @Autowired
    public CityRepo cityRepo;
    public City findById(Long id) {
        return cityRepo.findById(id).get();
    }
}
