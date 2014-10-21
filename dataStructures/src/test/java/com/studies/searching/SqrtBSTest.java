package com.studies.searching;

import org.junit.Test;
import static org.junit.Assert.*;

public class SqrtBSTest {
	
	@Test
	public void testSqrt(){
		assertEquals(2, SqrtBS.sqrt(4));
		assertEquals(1, SqrtBS.sqrt(3));
		assertEquals(3, SqrtBS.sqrt(9));
	}

	@Test
	public void testSqrtRecursively(){
		assertEquals(2, SqrtBS.sqrtRecursively(4));
		assertEquals(1, SqrtBS.sqrtRecursively(3));
		assertEquals(3, SqrtBS.sqrtRecursively(9));
	}
	
}
