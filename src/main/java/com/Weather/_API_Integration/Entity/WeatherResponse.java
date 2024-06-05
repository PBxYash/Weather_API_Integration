package com.Weather._API_Integration.Entity;

import lombok.Data;

@Data
public class WeatherResponse {
    private double longitude;
    private double latitude;
    private String weatherDescription;
    private double temperature;
    private double feelsLike;
    private double minimumTemperature;
    private double maximumTemperature;
}
