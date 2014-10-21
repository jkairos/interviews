package com.studies.recursion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DecimalToBinaryTest {
	
	private DecimalToBinary decimalToBinary;
	
	@Before
	public void setUp() throws Exception {
		decimalToBinary = new DecimalToBinary();
	}

	@Test(expected=IllegalArgumentException.class)
	public void testInvalidOption() {
		decimalToBinary.getBinary(-1);
	}
	
	@Test
	public void test(){
		assertEquals("11001", decimalToBinary.getBinary(25));
	}

}
