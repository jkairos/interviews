package com.studies.linkedList.singly;

public class LinkedListUtils <E>{
	
	public boolean isPalindrome(SinglyLinkedList<E> list){
		StringBuilder content = this.getContent(list);
		StringBuilder reverse = new StringBuilder(content);
		reverse = reverse.reverse();
		return content.toString().equals(reverse.toString());
	}
	
	private StringBuilder getContent(SinglyLinkedList<E> list){
		StringBuilder str = new StringBuilder();
		NodeLinkedList<E> node = list.getHead();
		while(node!=null){
			str.append(node.getElement());
			node = node.getNextNode();
		}
		return str;
	}
}
