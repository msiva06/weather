package com.system.weather.controller;

import com.system.weather.exception.ZipCodeNotFoundException;
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
        if(zipcode.isEmpty() || zipcode.trim().length() == 0 || zipcode.toLowerCase().equals("null")){
            throw new ZipCodeNotFoundException("Nothing to geocode");
        }
        for(int i = 0; i < zipcode.length(); i++) {
            if (!Character.isDigit(zipcode.charAt(i))) {
                throw new ZipCodeNotFoundException("Invalid zip code");
            }
        }
        return service.getTemperature(zipcode);
    }
}
