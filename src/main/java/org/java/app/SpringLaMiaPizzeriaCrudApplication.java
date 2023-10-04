package org.java.app;

import org.java.app.pojo.Pizza;
import org.java.app.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {
	

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Autowired
	private PizzaService pizzaService;
	
	@Override
	public void run(String... args) throws Exception {

		Pizza pizza1 = new Pizza("Marghi", "buona", null, 5f);
		Pizza pizza2 = new Pizza("Capri", "bella", null, 8f);
		Pizza pizza3 = new Pizza("Diavo", null, null, 9f);
		Pizza pizza4 = new Pizza("Tradi", "normi", null, 5f);
		Pizza pizza5 = new Pizza("Bosca", null, null, 7f);
		
		pizzaService.save(pizza1);
		pizzaService.save(pizza2);
		pizzaService.save(pizza3);
		pizzaService.save(pizza4);
		pizzaService.save(pizza5);
	}
}