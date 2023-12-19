package com.rindus.example.weather.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class Weather {

	
	@Min(-90)
	@Max(90)
	private Double latitude;
	
	@Min(-180)
	@Max(180)	
	private Double longitude;
	
	private Current current;

	private Hourly hourly;	
	
}
