package com.studies.linkedList.doubly;

public class Node <E> {
	private E element;
	private Node<E> prevNode;
	private Node<E> nextNode;
	
	public Node(E element, Node<E> prevNode, Node<E> nextNode){
		this.element = element;
		this.prevNode = prevNode;
		this.nextNode = nextNode;
	}

	
	public E getElement() {
		return element;
	}
	
	public void setElement(E element) {
		this.element = element;
	}
	
	public Node<E> getNextNode() {
		return nextNode;
	}
	
	public void setNextNode(Node<E> nextNode) {
		this.nextNode = nextNode;
	}


	public Node<E> getPrevNode() {
		return prevNode;
	}


	public void setPrevNode(Node<E> prevNode) {
		this.prevNode = prevNode;
	}
	
}
