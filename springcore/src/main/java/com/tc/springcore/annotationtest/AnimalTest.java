package com.tc.springcore.annotationtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tc.springcore.beans.Pet;
import com.tc.springcore.configurations.PetConfig;

public class AnimalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ApplicationContext context = new AnnotationConfigApplicationContext(PetConfig.class);
		ApplicationContext context = new ClassPathXmlApplicationContext("petConfig.xml");
		
		Pet pet = (Pet)context.getBean("pet");
//		pet.getAnimal().eat();
		pet.doSomething();
	}

}
