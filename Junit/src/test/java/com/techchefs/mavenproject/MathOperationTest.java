package com.techchefs.mavenproject;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathOperationTest {
	
	private MathOperation m=new MathOperation();
	
	@Test
	public void testAddMethod() {
		assertEquals(13, m.add(5, 8));
	}
	@Test
	public void testDivMethod() {
		assertEquals((int) 0.6, m.div(5, 8));
	}
	@Test(expected = ArithmeticException.class)
	public void testDivForException() {
		m.div(10, 0);
	}

}
