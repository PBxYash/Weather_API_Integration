package com.Weather._API_Integration.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {
    private double longitude;
    private double latitude;

    @JsonProperty("weather_description")
    private String weatherDescription;

    private double temperature;

    @JsonProperty("feels_like")
    private double feelsLike;

    @JsonProperty("minimum_temperature")
    private double minimumTemperature;

    @JsonProperty("maximum_temperature")
    private double maximumTemperature;

    // Parameterized constructor for ease of instantiation

}
