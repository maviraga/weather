package com.rindus.example.weather.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rindus.example.weather.model.Current;
import com.rindus.example.weather.model.Hourly;

import io.swagger.annotations.ApiOperation;

@RequestMapping(path = "/weather")
@RestController
public interface WeatherController {

	
	@ApiOperation(value = "Get current weather by coordinates (latitude, longitude)", notes = "Get current weather by coordinates (latitude, longitude)")
	@GetMapping("/current/{lat},{lon}")
	public ResponseEntity<Current> current(@PathVariable("lat") Double latitude, @PathVariable("lon") Double longitude);
	
	@ApiOperation(value = "Get hourly forecast weather for next seven days ", notes = "Get hourly forecast weather for next seven days")
	@GetMapping("/forecast/{lat},{lon}")
	public ResponseEntity<Hourly> forecast(@PathVariable("lat") Double latitude, @PathVariable("lon") Double longitude);
	
}
