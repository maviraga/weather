package com.rindus.example.weather.service.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rindus.example.weather.excepction.WeatherServiceException;
import com.rindus.example.weather.model.Current;
import com.rindus.example.weather.model.Hourly;

@Service
public interface WeatherService {
	ResponseEntity<Current> current(Double latitude, Double longitude) throws WeatherServiceException;
	ResponseEntity<Hourly> forecast(Double latitude, Double longitude) throws WeatherServiceException;

}
