package com.Weather._API_Integration.Service;

import com.Weather._API_Integration.Entity.OpenWeatherMapResponse;
import com.Weather._API_Integration.Entity.Units;
import com.Weather._API_Integration.Entity.WeatherResponse;
import com.Weather._API_Integration.Exception.UnauthorizedException;
import com.Weather._API_Integration.Exception.WeatherServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?lat={latitude}&lon={longitude}&appid={apiKey}&units={units}";
    @Autowired
    private  RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponse getCurrentWeather(String latitude, String longitude, String apiKey, Units units) {
        try {
            String url = API_URL.replace("{latitude}", latitude)
                    .replace("{longitude}", longitude)
                    .replace("{apiKey}", apiKey)
                    .replace("{units}", units.name().toLowerCase());

            OpenWeatherMapResponse response = restTemplate.getForObject(url, OpenWeatherMapResponse.class);

            return new WeatherResponse(
                    response.getCoord().getLon(),
                    response.getCoord().getLat(),
                    response.getWeather()[0].getDescription(),
                    response.getMain().getTemp(),
                    response.getMain().getFeelsLike(),
                    response.getMain().getTempMin(),
                    response.getMain().getTempMax()
            );
        } catch (HttpClientErrorException e) {
            HttpStatus statusCode = HttpStatus.resolve(e.getStatusCode().value());
            System.out.println(statusCode);
            ;
            if (statusCode == HttpStatus.UNAUTHORIZED) {
                throw new UnauthorizedException("Invalid API key. Please see https://openweathermap.org/faq#error401 for more info.");
            } else {
                throw new WeatherServiceException("An error occurred while fetching weather information: " + e.getMessage(), e);
            }
        }
    }
}
