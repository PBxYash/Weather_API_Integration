package com.Weather._API_Integration.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherRequest {
    private String latitude;
    private String longitude;
    private String date;
    private Units units;
    private Credentials credentials;
}
