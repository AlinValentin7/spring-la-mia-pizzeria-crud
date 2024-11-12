package it.exercise.java.spring.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.exercise.java.spring.mvc.model.Pizza;

public interface PizzeriaRepository extends JpaRepository<Pizza, Long> {

	public List<Pizza> findByNameContaining(String name);

}
