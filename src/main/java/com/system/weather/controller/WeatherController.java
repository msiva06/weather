package com.system.weather.controller;

import com.system.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService service;

    @GetMapping("/weather/{zipcode}")
    public float getTemperature(@PathVariable String zipcode){
        return service.getTemperature(zipcode);
    }
}
