package com.studies.linkedList.doubly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>();
		doublyLinkedList.insertElement(1);
		assertEquals("1", doublyLinkedList.traverse(TraverseLinkedList.FORWARD));

		doublyLinkedList.insertElement(2);
		assertEquals("1,2", doublyLinkedList.traverse(TraverseLinkedList.FORWARD));
		assertEquals("2,1", doublyLinkedList.traverse(TraverseLinkedList.BACKWARD));

		doublyLinkedList.insertElement(3);
		assertEquals("1,2,3", doublyLinkedList.traverse(TraverseLinkedList.FORWARD));
		assertEquals("3,2,1", doublyLinkedList.traverse(TraverseLinkedList.BACKWARD));

		doublyLinkedList.insertElementAtHead(11);
		assertEquals("11,1,2,3", doublyLinkedList.traverse(TraverseLinkedList.FORWARD));
		assertEquals("3,2,1,11", doublyLinkedList.traverse(TraverseLinkedList.BACKWARD));

		doublyLinkedList.removeLast();
		assertEquals("11,1,2", doublyLinkedList.traverse(TraverseLinkedList.FORWARD));
		assertEquals("2,1,11", doublyLinkedList.traverse(TraverseLinkedList.BACKWARD));
		
	}

}
