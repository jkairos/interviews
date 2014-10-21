package com.studies.linkedList.doubly;

public class DoublyLinkedList<E> {
	private Node<E> head;
	private Node<E> header;
	private Node<E> trailer;
	private int size;
	
	public DoublyLinkedList(){
		header = new Node<E>(null, null, null);
		trailer = new Node<E>(null, null, null);
	}
	
	//Inserts always at the tail O(1)
	public void insertElement(E element){
		if(head == null){
			head = new Node<E>(element, header,trailer);
			header.setNextNode(head);
			trailer.setPrevNode(head);
		}else{
			Node<E> node = new Node<E>(element,trailer.getPrevNode(),trailer);
			trailer.getPrevNode().setNextNode(node);
			trailer.setPrevNode(node);
		}
		size++;
	}

	public void insertElement(E element, Node<E> nodeAfter){
		Node<E> node = new Node<E>(element,nodeAfter,nodeAfter.getNextNode());
		nodeAfter.setNextNode(node);
		size++;
	}
	
	//O(1)
	public void insertElementAtHead(E element){
		Node<E> node = new Node<E>(element,header,header.getNextNode());
		header.getNextNode().setPrevNode(node);
		header.setNextNode(node);
		size++;
	}
	
	//O(1)
	public void removeLast(){
		if(size > 1){
			Node<E> v = trailer.getPrevNode();
			Node<E> u = v.getPrevNode();
			trailer.setPrevNode(u);
			u.setNextNode(trailer);
			v.setNextNode(null);
			v.setPrevNode(null);
			size--;
		}
	}
	
	
	public int getSize(){
		return size;
	}
	
	public String traverse(TraverseLinkedList traverseLinkedList){
		String traverse = traverseLinkedList.equals(TraverseLinkedList.FORWARD ) ? this.traverseForward(header.getNextNode()) : this.traverseBackward(trailer.getPrevNode());
		traverse = traverse.trim();
		traverse = traverse.substring(0,traverse.length()-1);
		System.out.println("Traverse: " + traverse);
		return traverse;
	}
	
	private String traverseForward(Node<E> node){
		if(node.getElement() == null){
			return "";
		}else{
			return node.getElement() +","+ traverseForward(node.getNextNode());
		}
	}

	private String traverseBackward(Node<E> node){
		if(node.getElement() == null){
			return "";
		}else{
			return node.getElement() +","+ traverseBackward(node.getPrevNode());
		}
	}
	
}
