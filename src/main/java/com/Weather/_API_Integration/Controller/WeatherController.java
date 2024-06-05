package com.Weather._API_Integration.Controller;

import com.Weather._API_Integration.Entity.Units;

import com.Weather._API_Integration.Entity.WeatherResponse;
import com.Weather._API_Integration.Exception.UnauthorizedException;
import com.Weather._API_Integration.Exception.WeatherServiceException;
import com.Weather._API_Integration.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Weather._API_Integration.Entity.ErrorResponse;
@RestController
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @PostMapping("/weather")
    public ResponseEntity<?> getCurrentWeather(
            @RequestParam String latitude,
            @RequestParam String longitude,
            @RequestParam String apiKey,
            @RequestParam Units units
    ) {
        try {
            WeatherResponse weatherResponse = weatherService.getCurrentWeather(
                    latitude,
                    longitude,
                    apiKey,
                    units
            );
            return ResponseEntity.ok(weatherResponse);
        } catch (UnauthorizedException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (WeatherServiceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse(e.getMessage()));
        }
    }
}