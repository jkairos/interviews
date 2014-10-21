package com.studies.recursion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FactorialTest {
	
	private Factorial factorial;
	
	@Before
	public void setUp() throws Exception {
		factorial = new Factorial();
	}

	@Test(expected=IllegalArgumentException.class)
	public void testInvalidOption() {
		factorial.getFactorial(-1);
	}
	
	@Test
	public void test(){
		assertEquals(24, factorial.getFactorial(4));
	}
}
