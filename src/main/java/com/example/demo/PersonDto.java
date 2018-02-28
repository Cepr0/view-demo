package com.example.demo;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Poznanski, 2018-02-28
 */
@Value
public class PersonDto {
	private String name;
	private List<CarDto> cars = new ArrayList<>();
	
	public PersonDto addCars(List<CarDto> cars) {
		this.cars.addAll(cars);
		return this;
	}
}
