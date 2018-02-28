package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 32, nullable = false)
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
}
