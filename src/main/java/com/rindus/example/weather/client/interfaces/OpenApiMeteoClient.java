package com.rindus.example.weather.client.interfaces;

import org.springframework.http.ResponseEntity;

import com.rindus.example.weather.excepction.WeatherServiceException;
import com.rindus.example.weather.model.Weather;

public interface OpenApiMeteoClient {
	
	ResponseEntity<Weather> weather(Double latitude, Double lontigude) throws WeatherServiceException ;
}
