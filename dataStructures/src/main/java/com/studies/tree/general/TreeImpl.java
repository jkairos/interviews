package com.studies.tree.general;

import java.util.ArrayList;
import java.util.List;

public class TreeImpl<E> implements Tree<E> {

	private Node<E> root;
	
	public TreeImpl(Node<E> root){
		this.root = root;
	}
	
	public Node<E> getRoot() {
		return root;
	}

	public Node<E> getParent(Node<E> node) {
		return node.getParent();
	}

	public List<Node<E>> getChildren(Node<E> node) {
		return node.getChildren() == null ? new ArrayList<Node<E>>() : node.getChildren();
	}

	public boolean isInternal(Node<E> node) {
		return node.getChildren()!=null && !root.getChildren().isEmpty();
	}

	public boolean isLeaf(Node<E> node) {
		return node.getChildren()==null || root.getChildren().isEmpty();
	}

	public boolean isRoot(Node<E> node) {
		return node.getParent() == null;
	}

	public int size() {
		return 0;
	}

	public boolean isEmpty() {
		return root == null;
	}
	
	public String traverse(Traversal traversal){
		String str = null;
		if(traversal.equals(Traversal.PRE_ORDER)){
			str = this.toStringPreOrder(root);
		}else{
			str = this.toStringPostOrder(root);
		}
		
		System.out.println(str);
		
		return str;
	}
	
	public String toStringPreOrder(Node<E> node){
		String str = node.getElement().toString();
		
		for(Node<E> n1: this.getChildren(node)){
			str+= ", " +  toStringPreOrder(n1);
		}
		
		return str;
	}

	public String toStringPostOrder(Node<E> node){
		String str="";
		for(Node<E> n1: this.getChildren(node)){
			str+= toStringPostOrder(n1)+", ";
		}
		
		str += node.getElement().toString();
		return str;
	}
	
	public int getHeight(){
		return this.getHeight(root);
	}
	
	private int getHeight(Node<E> node){
		int height = 0;

		if(this.isLeaf(node)){
			return 0;
		}else{
			for(Node<E> n1 : node.getChildren()){
				height = Math.max(height, getHeight(n1));
			}
		}
		
		return height + 1;
	}
}
