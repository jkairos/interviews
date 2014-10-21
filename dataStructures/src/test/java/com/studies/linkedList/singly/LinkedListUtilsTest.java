package com.studies.linkedList.singly;
import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListUtilsTest {
	
	@Test
	public void testIsPalindrome(){
		LinkedListUtils<Integer> linkedListUtils = new LinkedListUtils<Integer>();
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		
		list.insertElement(5);
		list.insertElement(8);
		list.insertElement(8);
		list.insertElement(5);
		
		assertTrue(linkedListUtils.isPalindrome(list));
	}

	@Test
	public void testIsPalindrome1(){
		LinkedListUtils<Integer> linkedListUtils = new LinkedListUtils<Integer>();
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		
		list.insertElement(5);
		list.insertElement(8);
		list.insertElement(8);
		list.insertElement(5);
		list.insertElement(3);
		list.insertElement(6);
		list.insertElement(7);
		
		assertEquals(false,linkedListUtils.isPalindrome(list));
	}
}
