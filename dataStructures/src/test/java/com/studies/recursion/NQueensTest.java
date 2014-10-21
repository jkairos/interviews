package com.studies.recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class NQueensTest {

	@Test
	public void test() {
		NQueens nQueens = new NQueens();
		nQueens.nQueens(0, 8);
	}

}
