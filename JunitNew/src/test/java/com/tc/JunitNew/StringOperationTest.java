package com.tc.JunitNew;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringOperationTest {

	private StringOperation s = new StringOperation();

	@Test
	public void testCountMethod() {
		assertEquals(5, s.count("Mohan"));
	}

	@Test(expected = NullPointerException.class)
	public void testCountCharInStringMethod() {
		assertEquals(5, s.count(null));
	}
}
