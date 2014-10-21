package com.studies.backtracking;

import org.junit.Test;

public class PermutationTest {

	@Test
	public void test() {
		String str="123";
		Permutation permutation = new Permutation();
		permutation.perm(str);
		str="ABCD";
		permutation.perm(str);
	}

}
