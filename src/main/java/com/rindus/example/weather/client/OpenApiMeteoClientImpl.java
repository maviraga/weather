package com.rindus.example.weather.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.rindus.example.weather.client.interfaces.OpenApiMeteoClient;
import com.rindus.example.weather.excepction.WeatherServiceException;
import com.rindus.example.weather.model.Weather;;

@Component
public class OpenApiMeteoClientImpl implements OpenApiMeteoClient {
	
	private static final String URL = "https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s"
			+ "&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m";
		
	@Autowired
	private RestTemplate restTemplate;

	
	public OpenApiMeteoClientImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}


	
	public ResponseEntity<Weather> weather(Double latitude, Double longitude) throws WeatherServiceException {
		try {
			String url = String.format(URL, latitude, longitude);			
			return restTemplate.getForEntity(url, Weather.class);
		} catch (Exception e) {
			throw new WeatherServiceException();
		}
	}	

}
