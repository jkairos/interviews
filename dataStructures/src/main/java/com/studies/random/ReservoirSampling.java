package com.studies.random;

import java.util.Random;

import com.studies.linkedList.singly.NodeLinkedList;
import com.studies.linkedList.singly.SinglyLinkedList;

public class ReservoirSampling {
	
	public final static int SAMPLE=1;
	private int count;
	private int data;

	public int selectRandomData(SinglyLinkedList<Integer> linkedList){
		return this.selectRandomData(linkedList.getHead());
	}
	
	private int selectRandomData(NodeLinkedList<Integer> node){
		if(node == null){
			return 0;
		}
		
		if(count < SAMPLE){
			data = node.getElement();
		}else{
			Random r = new Random();
			int n = r.nextInt(count);
			if(n < SAMPLE){
				data = node.getElement();
			}
		}
		count++;
		selectRandomData(node.getNextNode());
		return data;
		
	}
}
