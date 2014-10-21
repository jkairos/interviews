package com.studies.linkedList.singly;

public class Stack<E> {
	private Node<E> head = null;
	private int size;
	
	public void push(E element) throws IllegalArgumentException{
		if(element == null){
			throw new IllegalArgumentException();
		}
		
		if(head == null){
			head = new Node<E>(element, null);
		}else{
			Node<E> node = new Node<E>(element, head);
			head = node;
		}
		
		size++;
	}
	
	public Node<E> pop(){
		Node<E> node = null;
		if(head!=null){
			head = head.next;
			size--;
		}
		
		return node;
	}
	
	public String traverse(){
		String result = null;
		result = this.traverse(head);
		result = result.substring(0,result.length()-1);
		result = result.trim();
		System.out.println(result);
		return result;
	}
	
	
	private String traverse(Node<E> node){
		if(node == null){
			return "";
		}else{
			return node.element + "," + traverse(node.next);
		}
	}
	
	public int getSize(){
		return size;
	}
	
	protected static class Node<E>{
		E element;
		Node<E> next;
		
		public Node(E element, Node<E> next){
			this.element = element;
			this.next = next;
		}
	}
}
