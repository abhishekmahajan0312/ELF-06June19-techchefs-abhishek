package com.tc.springcoreassignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tc.springcoreassignment.interfaces.HP;
import com.tc.springcoreassignment.interfaces.Laptop;

@Configuration
public class BeanConfig {
	
	@Bean
	public Laptop getLaptop() {
		HP hp = new HP();
		hp.setBrand("Hp Elite Book");
		hp.setColor("Golden");
		hp.setCost(25000);
		hp.setWeight("1.2KG");
		hp.setRam("6GB");
		hp.setOs("Ubuntu");
		return hp;
	}
	
}
