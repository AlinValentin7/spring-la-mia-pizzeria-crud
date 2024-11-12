package it.exercise.java.spring.mvc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.exercise.java.spring.mvc.model.Pizza;
import it.exercise.java.spring.mvc.repository.PizzeriaRepository;

@Controller
@RequestMapping("/pizzerias")
public class PizzeriaController {
	
	@Autowired
	private PizzeriaRepository pizzeriaRep;
	@GetMapping
	public String index(@RequestParam(name = "key", required = false) String key, Model model) {
	    List<Pizza> allPizzas;

	    if (key != null && !key.isBlank()) {
	        allPizzas = pizzeriaRep.findByNameContaining(key);
	        model.addAttribute("key", key);
	    } else {
	        allPizzas = pizzeriaRep.findAll();
	    }
	    model.addAttribute("pizzerias", allPizzas); 
	    return "pizzerias/index";
	}

	
	@GetMapping("/detalis/{id}")
	public String details(@PathVariable(name = "id") Long id, String key,
			Model model) {
		
		Optional<Pizza> pizzaOpt = pizzeriaRep.findById(id);
		
		if (pizzaOpt.isPresent()) {
			model.addAttribute("pizza", pizzaOpt.get());
		}
		model.addAttribute("key", key);
		
		return "pizzerias/details";
	}
	
	
	

}
