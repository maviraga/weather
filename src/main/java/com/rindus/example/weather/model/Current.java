package com.rindus.example.weather.model;

import lombok.Data;

@Data
public class Current {
	/*
	 current": {
    	"time": "2022-01-01T15:00"
    	temperature_2m": 2.4,
    	"wind_speed_10m": 11.9,
  	}
	 */
	private String time;
		
	private Double temperature_2m;
	
	private Double wind_speed_10m;	

}
