package com.studies.backtracking;

import org.junit.Test;

public class SumOfSubsetsTest {

	@Test
	public void test() {
		int[] a = {1,3,4,2,5,6,7};
		SumOfSubsets sumOfSubsets = new SumOfSubsets();
		
		sumOfSubsets.sumOfSubsets(a, 10);
	}

}
