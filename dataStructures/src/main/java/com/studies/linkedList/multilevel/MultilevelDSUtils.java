package com.studies.linkedList.multilevel;

import com.studies.linkedList.doubly.TraverseLinkedList;


/**
 * If Java uses the pass-by reference, why won't a swap function work?
 * 
 * Your question demonstrates a common error made by Java language newcomers. Indeed, even seasoned veterans find it difficult to keep the terms straight.
 * 
 * Java does manipulate objects by reference, and all object variables are references. However, Java doesn't pass method arguments by reference; it passes them by value.
 * 
 * @param <E>
 */
public class MultilevelDSUtils<E> {
	
	public void flattenList(Node<E> head,Node<E> tail){
		Node<E> node = head;
		
		while(node!=null){
			if(node.getChild()!=null){
				tail = this.append(node.getChild(), tail);
			}
			node = node.getNext();
		}
	}
	
	//Append it is returning the new tail instead of just setting it because in JAVA all objects references are passed
	//by value, so if we just assign the tail to the new tail without returning it, this change gets lost
	//We can change object's attributes, since the reference still point to the original object, however, assigns and swaps will fail
	public Node<E> append(Node<E> child, Node<E> tail){
		Node<E> curNode = child;
		tail.setNext(child);
		child.setPrev(tail);
		
		while(true){
			if(curNode.getNext() == null){
				break;
			}else{
				curNode = curNode.getNext();
			}
		}
		
		tail = curNode;
		return tail;
	}
	

	public Node<E> unflattenList(Node<E> head,Node<E> tail){
		this.recursiveUnflatten(head);
		
		Node<E> cur = head;
		
		while(cur.getNext()!=null){
			cur =cur.getNext();
		}
		
		tail = cur;
		
		return tail;
	}
	
	private void recursiveUnflatten(Node<E> child){
		Node<E> currentNode = child;
		
		while(currentNode!=null){
			if(currentNode.getChild()!=null){
				currentNode.getChild().getPrev().setNext(null);
				currentNode.getChild().setPrev(null);
				recursiveUnflatten(currentNode);
			}
			
			currentNode = currentNode.getNext();
		}
	}
	
	public String traverse(Node<E> head,Node<E> tail,TraverseLinkedList traverseLinkedList){
		String traverse = traverseLinkedList.equals(TraverseLinkedList.FORWARD ) ? this.traverseForward(head) : this.traverseBackward(tail);
		traverse = traverse.trim();
		traverse = traverse.substring(0,traverse.length()-1);
		System.out.println("Traverse: " + traverse);
		return traverse;
	}
	
	private String traverseForward(Node<E> node){
		if(node == null){
			return "";
		}else{
			return node.getData() +","+ traverseForward(node.getNext());
		}
	}

	private String traverseBackward(Node<E> node){
		if(node == null){
			return "";
		}else{
			return node.getData() +","+ traverseBackward(node.getPrev());
		}
	}
	
}
