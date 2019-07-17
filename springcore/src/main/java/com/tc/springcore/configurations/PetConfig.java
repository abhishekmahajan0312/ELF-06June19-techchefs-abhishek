package com.tc.springcore.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tc.springcore.beans.Donkey;
import com.tc.springcore.beans.Monkey;
import com.tc.springcore.beans.Pet;
import com.tc.springcore.interfaces.Animal;

@Configuration
public class PetConfig {
	
	@Bean
	public Pet getPet() {
		return new Pet();
	}
//	@Bean
//	public Animal getAnimal() {
//		return new Donkey();
//	}
	@Bean(name="monkey")
	public Animal getMonkey() {
		return new Monkey();
	}
	@Bean(name="donkey")
	public Animal getDonkey() {
		return new Donkey();
	}
}
