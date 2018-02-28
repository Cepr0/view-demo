package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 32, nullable = false)
	private String brand;
	
	@Column(length = 32, nullable = false)
	private String model;
	
	@ManyToOne
	private Person person;
	
	public Car(String brand, String model, Person person) {
		this.brand = brand;
		this.model = model;
		this.person = person;
	}
}
