package it.exercise.java.spring.mvc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.exercise.java.spring.mvc.model.Pizza;
import it.exercise.java.spring.mvc.repository.PizzeriaRepository;
import it.lessons.libreria.model.Book;
import jakarta.validation.Valid;

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
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable(name = "id") Long id, @RequestParam(name = "keyword", required = false)  String key,
			Model model) {
		
		Optional<Pizza> pizzaOpt = pizzeriaRep.findById(id);
		
		if (pizzaOpt.isPresent()) {
			model.addAttribute("pizza", pizzaOpt.get());
		}
		model.addAttribute("key", key);
		if (key == null || key.isBlank() || key.equals("null")) {
			model.addAttribute("pizzaUrl", "/pizzerias");
		} else {
			model.addAttribute("pizzaUrl", "/pizzerias?key=" + key );
		}
		
		return "pizzerias/details";
	}
	
	@GetMapping("/insert")
	public String insert(Model model) {
		model.addAttribute("pizza", new Pizza());

		return "pizzerias/insert";
	}
	
	@PostMapping("/insert")
	public String insertP ( @Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		if(bindingResult.hasErrors()) {
			return"pizzerias/insert";
		}
		pizzeriaRep.save(formPizza);
		redirectAttributes.addFlashAttribute("insertMessage", "New pizza was insert");
		return "redirect:/pizzerias";
		
	}
	

}
