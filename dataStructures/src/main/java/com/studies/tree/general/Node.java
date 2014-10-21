package com.studies.tree.general;

import java.util.List;

public class Node<E> {
	private E element;
	private Node<E> parent;
	private List<Node<E>> children;
	
	public Node(E element,Node<E> parent,List<Node<E>> children){
		this.element = element;
		this.parent = parent;
		this.children = children;
	}

	public Node(E element,List<Node<E>> children){
		this.element = element;
		this.children = children;
	}

	public Node(E element){
		this.element = element;
		this.parent = null;
		this.children = null;
	}
	
	public E getElement() {
		return element;
	}
	
	public void setElement(E element) {
		this.element = element;
	}
	
	public Node<E> getParent() {
		return parent;
	}
	
	public void setParent(Node<E> parent) {
		this.parent = parent;
	}
	
	public List<Node<E>> getChildren() {
		return children;
	}
	
	public void setChildren(List<Node<E>> children) {
		this.children = children;
	}
	
	
	
}
