package com.rindus.example.weather.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rindus.example.weather.client.interfaces.OpenApiMeteoClient;
import com.rindus.example.weather.controller.WeatherControllerImpl;
import com.rindus.example.weather.excepction.WeatherServiceException;
import com.rindus.example.weather.model.Current;
import com.rindus.example.weather.model.Hourly;
import com.rindus.example.weather.model.Weather;
import com.rindus.example.weather.service.interfaces.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {
	
	Logger logger = LoggerFactory.getLogger(WeatherControllerImpl.class);

	@Autowired
	OpenApiMeteoClient openApiMeteoClient;
	
	public ResponseEntity<Current> current(Double latitude, Double longitude) throws WeatherServiceException {
		ResponseEntity<Weather> weather = openApiMeteoClient.weather(latitude, longitude);
		if (weather != null) {
			if (latitude == null || longitude == null) {
				throw new WeatherServiceException();
			}
			return ResponseEntity.ok(weather.getBody().getCurrent());
		} else {
			logger.warn("Current weather not available");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	public ResponseEntity<Hourly> forecast(Double latitude, Double longitude) throws WeatherServiceException {		
		ResponseEntity<Weather> weather = openApiMeteoClient.weather(latitude, longitude);
		if (weather != null) {
			if (latitude == null || longitude == null) {
				throw new WeatherServiceException();
			}
			return ResponseEntity.ok(weather.getBody().getHourly());
		} else {
			logger.warn("Forecast weather not available");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

}
