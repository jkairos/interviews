package com.studies.linkedList.multilevel;

import static org.junit.Assert.*;

import org.junit.Test;

import com.studies.linkedList.doubly.TraverseLinkedList;

public class MultilevelDSUtilsTest {

	@Test
	public void test() {
		Node<Integer> head= new Node<Integer>(null, null, null, 1);
		Node<Integer> tail= new Node<Integer>(null, null, null, 8);
		
		Node<Integer> headChildSB= new Node<Integer>(null, null, null, 4);
		Node<Integer> headChildChild= new Node<Integer>(null, null, null, 3);

		Node<Integer> headChild= new Node<Integer>(headChildSB, null, headChildChild, 2);
		headChildSB.setPrev(headChild);
		head.setChild(headChild);
		
		Node<Integer> node1 = new Node<Integer>(null, head, null, 5);
		head.setNext(node1);
		
		Node<Integer> node2 = new Node<Integer>(null, node1, null, 6);
		node1.setNext(node2);

		Node<Integer> node2Child = new Node<Integer>(null, null, null, 7);
		node2.setChild(node2Child);

		tail.setPrev(node2);
		node2.setNext(tail);
		
		Node<Integer> tailChild = new Node<Integer>(null, null, null, 9);
		tail.setChild(tailChild);
		
		MultilevelDSUtils<Integer> multilevelDSUtils = new MultilevelDSUtils<Integer>();
		multilevelDSUtils.flattenList(head, tail);
		assertEquals("1,5,6,8,2,4,7,9,3",multilevelDSUtils.traverse(head, tail, TraverseLinkedList.FORWARD));
		
	}

}
