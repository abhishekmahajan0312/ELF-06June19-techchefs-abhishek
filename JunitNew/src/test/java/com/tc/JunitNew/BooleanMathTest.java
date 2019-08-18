package com.tc.JunitNew;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BooleanOperationTest.class, MathOperationTest.class })
public class BooleanMathTest {

}
