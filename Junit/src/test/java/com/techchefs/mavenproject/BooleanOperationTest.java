package com.techchefs.mavenproject;

import static org.junit.Assert.*;

import org.junit.Test;

public class BooleanOperationTest {
	private BooleanOperation b = new BooleanOperation();
	
	@Test
	public void testCheckOddEvenMethod() {
		assertEquals(true, b.checkOddEven(0));
	}
	@Test
	public void testDivisibleByThree() {
		assertEquals(true, b.divisibleByThree(9));
	}

}
