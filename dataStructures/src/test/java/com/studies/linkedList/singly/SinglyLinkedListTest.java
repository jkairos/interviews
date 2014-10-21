package com.studies.linkedList.singly;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SinglyLinkedListTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
		singlyLinkedList.insertElement(1);
		assertEquals("1", singlyLinkedList.traverse());

		singlyLinkedList.insertElement(2);
		assertEquals("1,2", singlyLinkedList.traverse());

		singlyLinkedList.insertElement(3);
		assertEquals("1,2,3", singlyLinkedList.traverse());

		singlyLinkedList.insertElementAtHead(11);
		assertEquals("11,1,2,3", singlyLinkedList.traverse());

		singlyLinkedList.remove();
		assertEquals("1,2,3", singlyLinkedList.traverse());
		
	}
	
	@Test
	public void testRemoveDuplicates() {
		
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
		singlyLinkedList.insertElement(1);
		singlyLinkedList.insertElement(3);
		singlyLinkedList.insertElement(2);
		singlyLinkedList.insertElement(1);
		singlyLinkedList.insertElement(5);
		singlyLinkedList.insertElement(2);
		
		singlyLinkedList.removeDuplicates();
		assertEquals("1,3,2,5", singlyLinkedList.traverse());
	
	}
	
	@Test
	public void testFindNTHTOLastElement(){
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
		singlyLinkedList.insertElement(1);
		singlyLinkedList.insertElement(3);
		singlyLinkedList.insertElement(2);
		singlyLinkedList.insertElement(1);
		singlyLinkedList.insertElement(5);
		singlyLinkedList.insertElement(2);
		singlyLinkedList.insertElement(6);
		singlyLinkedList.insertElement(7);
		singlyLinkedList.insertElement(8);
		singlyLinkedList.removeDuplicates();
		
		assertEquals(Integer.valueOf(6), singlyLinkedList.findNTHTOLastElement(3));
		
	}
	
	@Test
	public void testSum(){
		SinglyLinkedList<Integer> s1 = new SinglyLinkedList<Integer>();
		s1.insertElement(3);
		s1.insertElement(1);
		s1.insertElement(5);

		SinglyLinkedList<Integer> s2 = new SinglyLinkedList<Integer>();
		s2.insertElement(5);
		s2.insertElement(9);
		s2.insertElement(2);
		
		SinglyLinkedList<Integer> sum = s1.sum(s1, s2);
		assertEquals("8,0,8", sum.traverse());
	}

	@Test
	public void testSum2(){
		SinglyLinkedList<Integer> s1 = new SinglyLinkedList<Integer>();
		s1.insertElement(3);
		
		SinglyLinkedList<Integer> s2 = new SinglyLinkedList<Integer>();
		s2.insertElement(0);
		s2.insertElement(1);
		
		SinglyLinkedList<Integer> sum = s1.sum(s1, s2);
		assertEquals("3,1", sum.traverse());
	}
	
	@Test
	public void testGetNodeAtBeginningOfLoop(){
		SinglyLinkedList<String> s1 = new SinglyLinkedList<String>();

		NodeLinkedList<String> head = new NodeLinkedList<String>("A");
		NodeLinkedList<String> node1 = new NodeLinkedList<String>("B");
		NodeLinkedList<String> node2 = new NodeLinkedList<String>("C");
		NodeLinkedList<String> node3 = new NodeLinkedList<String>("D");
		NodeLinkedList<String> node4 = new NodeLinkedList<String>("E");
		
		head.nextNode = node1;
		node1.nextNode = node2;
		node2.nextNode = node3;
		node3.nextNode = node4;
		node4.nextNode = node2;
		
		NodeLinkedList<String> nodeAtBeg = s1.getNodeAtBeginningOfLoop(head);
		assertEquals("C", nodeAtBeg.element);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetNodeAtBeginningOfLoopExc(){
		SinglyLinkedList<String> s1 = new SinglyLinkedList<String>();
		
		NodeLinkedList<String> head = new NodeLinkedList<String>("A");
		NodeLinkedList<String> node1 = new NodeLinkedList<String>("B");
		NodeLinkedList<String> node2 = new NodeLinkedList<String>("C");
		NodeLinkedList<String> node3 = new NodeLinkedList<String>("D");
		NodeLinkedList<String> node4 = new NodeLinkedList<String>("E");
		
		head.nextNode = node1;
		node1.nextNode = node2;
		node2.nextNode = node3;
		node3.nextNode = node4;
		node4.nextNode = null;
		
		NodeLinkedList<String> nodeAtBeg = s1.getNodeAtBeginningOfLoop(head);
	}
	
	@Test
	public void testReverse(){
		SinglyLinkedList<String> s1 = new SinglyLinkedList<String>();
		s1.insertElement("A");
		s1.insertElement("B");
		s1.insertElement("C");
		s1.insertElement("D");
		s1.traverse();
		s1 = s1.reverse(s1);
		s1.traverse();
		
	}

}
