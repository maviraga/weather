package com.rindus.example.weather.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.rindus.example.weather.controller.interfaces.WeatherController;
import com.rindus.example.weather.model.Current;
import com.rindus.example.weather.model.Hourly;
import com.rindus.example.weather.service.interfaces.WeatherService;

@RestController
public class WeatherControllerImpl implements WeatherController {

	Logger logger = LoggerFactory.getLogger(WeatherControllerImpl.class);
	
	@Autowired
	WeatherService weatherService;
	
	/**
	 * Get the current weather by coordinates
	 * 
	 * @param latitude
	 * @param longitude
	 * @return current weather
	 */
	public ResponseEntity<Current> current(Double latitude, Double longitude) {
		logger.info("Init current method");
		ResponseEntity<Current> currentWeather;
		try {
			currentWeather = weatherService.current(latitude, longitude);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return currentWeather;
	}
	
	/**
	 * Get the forecast weather by coordinates
	 * 
	 * @param latitude
	 * @param longitude
	 * @return forecast(hourly) weather
	 */
	public ResponseEntity<Hourly> forecast(Double latitude, Double longitude) {
		logger.info("Init forecast method");
		ResponseEntity<Hourly> forecastWeather;
		try {
			forecastWeather = weatherService.forecast(latitude, longitude);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return forecastWeather;
	}
	

}
