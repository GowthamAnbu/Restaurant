package com.gowtham.model;

import java.time.LocalTime;

import lombok.Data;
@Data
public class Session {
	private Integer id;
	private String name;
	private LocalTime startTime;
	private LocalTime endTime;
}
