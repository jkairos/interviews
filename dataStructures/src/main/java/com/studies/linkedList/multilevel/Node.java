package com.studies.linkedList.multilevel;

public class Node<E> {
	private Node<E> next;
	private Node<E> prev;
	private Node<E> child;
	private E data;
	
	public Node(Node<E> next,Node<E> prev,Node<E> child, E data){
		this.next = next;
		this.prev = prev;
		this.child = child;
		this.data = data;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	public Node<E> getPrev() {
		return prev;
	}

	public void setPrev(Node<E> prev) {
		this.prev = prev;
	}

	public Node<E> getChild() {
		return child;
	}

	public void setChild(Node<E> child) {
		this.child = child;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}
	
	
}
