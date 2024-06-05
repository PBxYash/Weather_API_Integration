package com.Weather._API_Integration.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class WeatherServiceException extends RuntimeException {
    public WeatherServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}