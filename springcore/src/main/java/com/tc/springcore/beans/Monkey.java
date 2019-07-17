package com.tc.springcore.beans;

import com.tc.springcore.interfaces.Animal;

public class Monkey implements Animal {

	@Override
	public void eat() {
		System.out.println("Eating Banana");
		// TODO Auto-generated method stub

	}

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Monkey is making Sound");
	}

}
