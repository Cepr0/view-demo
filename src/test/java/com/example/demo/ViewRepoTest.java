package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ViewRepoTest {
	
	@Autowired private ViewRepo viewRepo;
	
	@Test
	public void findAll() {
		final List<View> views = viewRepo.findAll();
		assertThat(views).hasSize(4);
		assertThat(views.get(0).getPersonName()).isEqualTo("person1");
		assertThat(views.get(1).getPersonName()).isEqualTo("person1");
		assertThat(views.get(2).getPersonName()).isEqualTo("person2");
		assertThat(views.get(3).getPersonName()).isEqualTo("person2");
	}
	
	@Test
	public void findByPersonName() {
		final List<View> views = viewRepo.findByPersonName("person1");
		assertThat(views).hasSize(2);
		assertThat(views.get(0).getPersonName()).isEqualTo("person1");
		assertThat(views.get(1).getPersonName()).isEqualTo("person1");
	}
	
	@Test
	public void getPersonByName() {
		final PersonDto person = viewRepo.getPersonByName("person1");
		assertThat(person).isNotNull();
		assertThat(person.getName()).isEqualTo("person1");
		assertThat(person.getCars()).hasSize(2);
	}
}