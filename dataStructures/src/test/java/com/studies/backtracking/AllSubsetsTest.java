package com.studies.backtracking;

import org.junit.Test;

public class AllSubsetsTest {

	@Test
	public void test() {
		Integer[] a = {1,2,3};
		AllSubsets<Integer> allSubsets = new AllSubsets<Integer>();
		allSubsets.subset(a);
	}

}
