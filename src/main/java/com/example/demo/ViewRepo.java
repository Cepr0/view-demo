package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ViewRepo extends JpaRepository<View, View> {
	List<View> findByPersonName(@Param("name") String name);
}
