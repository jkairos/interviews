package com.studies.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayUtilsTest {

	@Test
	public void testNumSumsOfTwoEven() {
		int array[] = {1,2,3,4,5};
		assertEquals(4, ArrayUtils.getNumSumsOfTwoEven(array));
	}

	@Test
	public void testEquilibriumIndex() {
		int array[] = {-7,1,5,2,-4,3,0};
		assertEquals(3, ArrayUtils.equi(array));
	}

	@Test
	public void testFirstCoveringPrefix() {
		int array[] = {2,2,1,0,1};
		assertEquals(3, ArrayUtils.firstCoveringPrefix(array));
	}

}
