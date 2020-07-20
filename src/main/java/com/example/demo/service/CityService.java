package com.example.demo.service;

import com.example.demo.model.City;

public interface CityService {
    Iterable<City> findAll();
    City findById(Long id);
    City save(City comment);
    void remove(Long id);
}
