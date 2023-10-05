package org.java.app.mvc.controller;

import java.util.List;

import org.java.app.pojo.Pizza;
import org.java.app.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/")
	public String getIndex(@RequestParam(required=false) String nome, Model model) {
		
		List<Pizza> pizze = null;
		                         
		pizze = nome == null ? pizzaService.findAll() : pizzaService.findByName(nome);
		
		model.addAttribute("nome", nome);
		model.addAttribute("pizze", pizze);
		
		return "index";
	}
	
	@GetMapping("/{id}")
	public String pizza(@PathVariable int id, Model model) {
		
		Pizza pizza = pizzaService.findById(id);
		
		model.addAttribute("pizza", pizza);
		
		return "show";
	}
}
