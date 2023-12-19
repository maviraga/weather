package com.rindus.example.weather.model;

import java.util.List;

import lombok.Data;

@Data
public class Hourly {
	/*
	 "hourly": {
    	"time": ["2022-07-01T00:00","2022-07-01T01:00", ...]
    	"wind_speed_10m": [3.16,3.02,3.3,3.14,3.2,2.95, ...],
    	"temperature_2m": [13.7,13.3,12.8,12.3,11.8, ...],
    	"relative_humidity_2m": [82,83,86,85,88,88,84,76, ...],
  	}
	 */
	
	private List<String> time;
	
	private List<Double> wind_speed_10m;
	
	private List<Double> temperature_2m;
	
	private List<Integer> relative_humidity_2m;

}
