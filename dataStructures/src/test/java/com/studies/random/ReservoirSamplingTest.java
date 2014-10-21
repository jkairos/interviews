package com.studies.random;

import org.junit.Test;

import com.studies.linkedList.singly.SinglyLinkedList;

public class ReservoirSamplingTest {
	
	@Test
	public void test(){
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
		linkedList.insertElement(1);
		linkedList.insertElement(3);
		linkedList.insertElement(5);
		linkedList.insertElement(11);
		linkedList.insertElement(60);
		linkedList.insertElement(89);
		linkedList.insertElement(80);
		linkedList.insertElement(67);
		linkedList.insertElement(890);
		linkedList.insertElement(111);
		linkedList.insertElement(133);
		linkedList.insertElement(156);
		linkedList.insertElement(178);
		linkedList.insertElement(1890);
		linkedList.insertElement(1123);
		linkedList.insertElement(1345);
		linkedList.insertElement(1233);
		linkedList.insertElement(1456);
		linkedList.insertElement(14);
		linkedList.insertElement(15);
		linkedList.insertElement(17);
		linkedList.insertElement(18);
		
		ReservoirSampling rs = new ReservoirSampling();
		System.out.println(rs.selectRandomData(linkedList));
	}
}
