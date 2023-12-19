package com.rindus.example.weather.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.rindus.example.weather.model.Weather;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class OpenApiMeteoClientTest {
	
	private static final String URL = "https://api.open-meteo.com/v1/forecast?latitude=36.721220778590904&longitude=-4.418371946027572"
			+ "&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m";
	 
	
	@Mock
	RestTemplate restTemplate;
	
	@Mock
	HttpHeaders headers;
	
	@InjectMocks
	private OpenApiMeteoClientImpl client;
	
	@Test
	void shoulReturnCurrentandForecastWeatherInMalaga() {	
		//Málaga Coordinates
		Double latitude = 36.721220778590904;
		Double longitude = -4.418371946027572;
		Weather weather = new Weather();
		weather.setLatitude(latitude);
		weather.setLongitude(longitude);		
		when(restTemplate.getForEntity(URL, Weather.class)).thenReturn(new ResponseEntity<Weather>(weather, HttpStatus.OK));
		client = new OpenApiMeteoClientImpl(restTemplate);
		ResponseEntity<Weather> result = client.weather(latitude, longitude);
		assertNotNull(result.getBody());
		assertEquals(result.getBody().getLatitude(), latitude);
		assertEquals(result.getBody().getLongitude(), longitude);		
		assertEquals(result.getStatusCode(), HttpStatus.OK);		
	}	

}
