package com.studies.linkedList.singly;

import java.util.HashSet;
import java.util.Set;

public class SinglyLinkedList<E> {
	private NodeLinkedList<E> head;
	private int size;
	
	public SinglyLinkedList(){}
	
	public SinglyLinkedList(NodeLinkedList<E> head){
		this.head = head;
	}
	
	//Inserts always at the tail O(n)
	public void insertElement(E element){
		if(head == null){
			head = new NodeLinkedList<E>(element, null);
		}else{
			NodeLinkedList<E> node = new NodeLinkedList<E>(element,null);
			this.getTail(head).nextNode = node;
		}
		size++;
	}
	
	//O(1)
	public void insertElementAtHead(E element){
		if(head == null){
			head = new NodeLinkedList<E>(element, null);
		}else{
			NodeLinkedList<E> node = new NodeLinkedList<E>(element,head);
			head = node;
		}
		size++;
	}
	
	//O(n)
	private NodeLinkedList<E> getTail(NodeLinkedList<E> node){
		if(node.nextNode == null){
			return node;
		}else{
			return getTail(node.nextNode);
		}
	}
	
	//O(1)
	public void remove(){
		if(head!=null && size > 1){
			head = head.nextNode;
			size--;
		}
	}
	
	public void removeDuplicates(){
		Set<E> hashSet = new HashSet<E>();
		NodeLinkedList<E> prev = null;
		NodeLinkedList<E> node = head;
		
		while(node!=null){

			if(hashSet.contains(node.element)){
				prev.nextNode = node.nextNode;
				size--;
			}else{
				hashSet.add(node.element);
			}
			prev = node;
			node = node.nextNode;
		}
		
	}
	
	
	public E findNTHTOLastElement(int n){
		int l = size-n;
		int count = 0;
		NodeLinkedList<E> node= head;
		
		while(count!=l){
			node = node.nextNode;
			count++;
		}
		
		return node.element;
	}
	
	public SinglyLinkedList<Integer> sum(SinglyLinkedList<Integer> s1, SinglyLinkedList<Integer> s2){
		SinglyLinkedList<Integer> result = new SinglyLinkedList<Integer>();
		Integer number1 = this.getNumber(s1.head);
		Integer number2 = this.getNumber(s2.head);
		String sumStr = String.valueOf(number1+number2);
		char[] array = sumStr.toCharArray();
		
		for (int i = array.length-1; i >= 0; i--){
			result.insertElement(Integer.valueOf(String.valueOf(array[i])));
		}
		
		return result;
	}
	
	private Integer getNumber(NodeLinkedList<Integer> node){
		return Integer.valueOf(this.getNumberRecursively(node));
	}
	
	private String getNumberRecursively(NodeLinkedList<Integer> node){
		if(node.nextNode == null){
			return String.valueOf(node.element);
		}
		return getNumberRecursively(node.nextNode)+String.valueOf(node.element);
	}
	
	public int getSize(){
		return size;
	}
	
	public NodeLinkedList<E> getNodeAtBeginningOfLoop(NodeLinkedList<E> head) throws IllegalArgumentException{
		NodeLinkedList<E> result = null;
		NodeLinkedList<E> slow = head;
		NodeLinkedList<E> fast = head.nextNode;
		
		while(true){
			if(fast == null || fast.nextNode == null){
				throw new IllegalArgumentException("This method only works for circular linked lists. The list passed is acyclic");
			}else if (slow.element.equals(fast.element) || fast.nextNode.element.equals(slow.element)){
				result = slow;
				break;
			}
			slow =slow.nextNode;
			fast = fast.nextNode.nextNode;
		}
		
		return result;
	}
	
	public String traverse(){
		String traverse = this.traverse(head);
		traverse = traverse.trim();
		traverse = traverse.substring(0,traverse.length()-1);
		System.out.println("Traverse: " + traverse);
		return traverse;
	}
	
	private String traverse(NodeLinkedList<E> node){
		if(node == null){
			return "";
		}else{
			return node.element +","+ traverse(node.nextNode);
		}
	}
	
	public NodeLinkedList<E> getHead(){
		return head;
	}
	
	public SinglyLinkedList<E> reverse(SinglyLinkedList<E> list){
		return this.reverse(list.head);
	}
	
	private SinglyLinkedList<E> reverse(NodeLinkedList<E> nodeList){
		NodeLinkedList<E> newNode = null;
		NodeLinkedList<E> node = null;
		
		while(nodeList!=null){
			node = nodeList;
			nodeList = nodeList.nextNode;
			node.nextNode = newNode;
			newNode = node;
		}
		
		return new SinglyLinkedList<E>(newNode);
	}
	
}
