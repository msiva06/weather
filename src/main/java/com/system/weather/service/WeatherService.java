package com.system.weather.service;

import com.system.weather.model.WeatherObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WeatherService {
    @Value("${com.system.weather.service.weatherservice.apikey}")
    private String apikey;

    public float getTemperature(String zipcode){

        RestTemplate restTemplate = new RestTemplate();
        WeatherObject weatherObject = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?zip={zipcode}&units=metric&appid={apikey}",
                WeatherObject.class, Map.of("zipcode",zipcode,"apikey",apikey));
        return weatherObject.main().temp();
    }
}
