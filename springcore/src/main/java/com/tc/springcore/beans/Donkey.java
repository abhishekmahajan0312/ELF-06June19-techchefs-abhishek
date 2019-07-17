package com.tc.springcore.beans;

import com.tc.springcore.interfaces.Animal;

public class Donkey implements Animal {

	@Override
	public void eat() {
		System.out.println("Eating grass");
		// TODO Auto-generated method stub

	}

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Dhechu Dhechu...");
	}
}
