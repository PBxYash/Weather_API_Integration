package com.Weather._API_Integration.Entity;

import lombok.Data;

@Data
public class OpenWeatherMapResponse {
    private Coord coord;
    private Weather[] weather;
    private Main main;
}