package com.studies.linkedList.singly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		assertEquals("1", stack.traverse());

		stack.push(2);
		assertEquals("2,1", stack.traverse());

		stack.push(3);
		assertEquals("3,2,1", stack.traverse());

		stack.push(11);
		assertEquals("11,3,2,1", stack.traverse());

		stack.pop();
		assertEquals("3,2,1", stack.traverse());
		
	}

}
