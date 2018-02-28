package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

import static java.util.Arrays.asList;

@SpringBootApplication
public class Application {
	
	private final PersonRepo personRepo;
	private final CarRepo carRepo;
	
	public Application(PersonRepo personRepo, CarRepo carRepo) {
		this.personRepo = personRepo;
		this.carRepo = carRepo;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@EventListener
	void appReadyHandler(ApplicationReadyEvent e) {
		final List<Person> people = personRepo.save(asList(new Person("person1"), new Person("person2")));
		
		carRepo.save(asList(
				new Car("brand1", "model1", people.get(0)),
				new Car("brand2", "model2", people.get(0)),
				new Car("brand3", "model3", people.get(1)),
				new Car("brand4", "model4", people.get(1))
		));
	}
}
