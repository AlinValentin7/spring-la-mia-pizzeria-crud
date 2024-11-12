package it.exercise.java.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ReDirIndexController {
	
	@GetMapping
	public String index() {
		return "redirect:/pizzas";
	}

}