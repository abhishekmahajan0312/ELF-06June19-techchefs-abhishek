package com.techchefs.mavenproject;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MathOperationMultiValueTest {

	private MathOperation m = new MathOperation();

	private int a;
	private int b;
	private int c;

	public MathOperationMultiValueTest(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Parameters
	public static Collection<Object[]> getValues() {
		Object[][] obj = { { 3, 6 }, { 7, 2 }, { 9, 3 }, { 8, 9 } };
		return Arrays.asList(obj);
	}

	@Test
	public void testAddMethod() {

	}

}
