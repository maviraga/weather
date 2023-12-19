package com.rindus.example.weather.controller;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rindus.example.weather.constant.ErrorConstant;
import com.rindus.example.weather.excepction.WeatherError;
import com.rindus.example.weather.excepction.WeatherServiceException;

@RestControllerAdvice
public class WeatherControllerExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {WeatherServiceException.class})
	public ResponseEntity<WeatherError> WeatherServiceException(RuntimeException exception, WebRequest request){
		WeatherError weatherError = createWeatherError(request);
		weatherError.setMessage(ErrorConstant.NULL_PARAMETER);
		weatherError.setStatus(HttpStatus.NOT_FOUND);
	    return new  ResponseEntity<WeatherError>(weatherError, HttpStatus.NOT_FOUND);
	}
	
	
	public WeatherError createWeatherError(WebRequest request){
		WeatherError weatherError = new WeatherError();
		weatherError.setInstant(Instant.now());
		weatherError.setPath(request.getContextPath());
	    return  weatherError;
	}

}
