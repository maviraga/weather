package com.rindus.example.weather.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rindus.example.weather.WeatherApplication;
import com.rindus.example.weather.service.interfaces.WeatherService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WeatherApplication.class)
@AutoConfigureMockMvc
public class WeatherControllerTest {
	
	@InjectMocks
	private WeatherControllerImpl controller;
	
	@Mock 
	WeatherService weatherService;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testGetCurrentWeather() throws Exception {		
		mvc.perform(get("/weather/current/{lat},{lon}",36.721220778590904,-4.418371946027572).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
		
	@Test
	public void testGetForecastWeather() throws Exception {
		mvc.perform(get("/weather/forecast/{lat},{lon}",36.721220778590904,-4.418371946027572).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	public void testGetCurrentWeatherWithoutLatitudeAndLongitude() throws Exception {
		mvc.perform(get("/weather/current/").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
	}
	
	@Test
	public void testGetForecastWeatherWithoutLatitudeAndLongitude() throws Exception {
		mvc.perform(get("/weather/forecast/").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
	}

}
