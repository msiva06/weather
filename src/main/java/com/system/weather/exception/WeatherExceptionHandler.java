package com.system.weather.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WeatherExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<WeatherErrorResponse> zipCodeNotFoundHandler(ZipCodeNotFoundException ex, HttpServletRequest req){
        WeatherErrorResponse error = new WeatherErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
