package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Collectors;

public interface ViewRepo extends JpaRepository<View, View> {
	List<View> findByPersonName(@Param("name") String name);
	
	default PersonDto getPersonByName(String personName) {
		return new PersonDto(personName)
				.addCars(findByPersonName(personName)
						.stream()
						.map(p -> new CarDto(p.getCarBrand(), p.getCarModel()))
						.collect(Collectors.toList()));
	}
}
