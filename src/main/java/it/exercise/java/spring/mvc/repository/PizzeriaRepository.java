package it.exercise.java.spring.mvc.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import it.exercise.java.spring.mvc.model.Pizzeria;
public interface PizzeriaRepository extends JpaRepository<Pizzeria, Long> {

	
}
