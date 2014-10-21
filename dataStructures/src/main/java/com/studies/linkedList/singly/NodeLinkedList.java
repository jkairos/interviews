package com.studies.linkedList.singly;

public class NodeLinkedList<E> {
	E element;
	NodeLinkedList<E> nextNode;
	
	public NodeLinkedList(E element){
		this.element = element;
		this.nextNode = null;
	}

	public NodeLinkedList(E element, NodeLinkedList<E> nextNode){
		this.element = element;
		this.nextNode = nextNode;
	}
	
	public E getElement(){
		return element;
	}
	
	public NodeLinkedList<E> getNextNode(){
		return nextNode;
	}
	
}
