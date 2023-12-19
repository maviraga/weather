package com.rindus.example.weather.excepction;

import java.time.Instant;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.Setter;

@Data
public class WeatherError {
	private HttpStatus status;
	@Setter
    private String path;
	@Setter
    private String message;
	@Setter
    private Instant instant;
}
