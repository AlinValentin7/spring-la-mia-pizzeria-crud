package it.exercise.java.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.exercise.java.spring.mvc.repository.PizzeriaRepository;

@Controller
@RequestMapping("/pizzerias")
public class PizzeriaController {
	
	@Autowired
	private PizzeriaRepository pizzeriaRep;
	@GetMapping
	public String index (Model model) {
		model.addAttribute("pizzerias", pizzeriaRep.findAll());
		return "pizzerias/index";
	}

}
