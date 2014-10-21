package com.studies.tree.bst;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

import com.studies.linkedList.singly.SinglyLinkedList;

public class BinaryTree<E> implements Iterable<E> {

	protected Node<E> root;

	private int size;

	public BinaryTree() {
		this.root = null;
	}

	public BinaryTree(Node<E> root) {
		this.root = root;
	}

	public boolean add(E element) {
		if (root == null) {// empty tree
			if (element == null)
				throw new NullPointerException();
			root = new Node<E>(element, null);
			return true;
		} else {
			Node<E> temp = root;
			int comp;
			while (true) {
				comp = ((Comparable) element).compareTo(temp.element);
				if (comp == 0){
					return false;
				}
				
				if (comp < 0){
					if (temp.left != null)
						temp = temp.left;
					else {
						temp.left = new Node<E>(element, temp);
						return true;
					} // temp.left == null
				}else if (temp.right != null){
					temp = temp.right;
				}else {
					temp.right = new Node<E>(element, temp);
					return true;
				} // temp.right == null
			} // while
		} // root not null
	} // method add

	public Node<E> findNode(E element) {
		return this.findNode(root, element);
	}

	private Node<E> findNode(Node<E> root,E element) {
		int comp = 0;
		
		if (root == null) {
			return null;
		}
		
		comp = (((Comparable) element).compareTo(root.element));
		
		if (comp == 0) {
			return root;
		} else if (comp < 0) {
			return findNode(root.left, element);
		} else {
			return findNode(root.right, element);
		}
		
	}

	public Node<E> findLowestCommonAncestor(Node<E> root, Node<E> child1, Node<E> child2) {
		if (root == null || child1 == null || child2 == null) {
			return null;
		} else {
			return this.findLowestCommonAncestor(root, child1.element, child2.element);
		}
	}
	
	public Node<E> findLowestCommonAncestorBT(Node<E> root, Node<E> n1, Node<E> n2){
		
		Node<E> left = null;
		Node<E> right = null;
		Node<E> temp = null;
	     
		if(root==null){
			return null;
	    }

	    if(root.left==n1 || root.left==n2 || root.right ==n1 || root.right ==n2){
	        return root;
	    }else{
	        left=findLowestCommonAncestorBT(root.left , n1 , n2);
	        right=findLowestCommonAncestorBT(root.right , n1, n2);

	        if(left!=null && right!=null){
	            return root;
	        }else{
	        	temp = (left!=null)?left:right;
	        	return temp;
	        }
	    }		
	}
	
	public int getAmountOfLeaves() {
		return this.getAmountOfLeaves(root);
	}

	private int getAmountOfLeaves(Node<E> root) {
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return 1;
		} else {
			return this.getAmountOfLeaves(root.left) + this.getAmountOfLeaves(root.right);
		}
	}
	
	public boolean isBalanced(){
		boolean result = false;
		
		if(root == null){
			result = true;
		}else{
			int heightLeftSubTree = this.getTreeHeight(root.left);
			int heightRightSubTree = this.getTreeHeight(root.right);
			
			if(Math.abs(heightLeftSubTree-heightRightSubTree) <=1.0D){
				result = true;
			}
		}
		
		return result;
	}
	
	public int getHeight() {
		return this.getTreeHeight(root);
	}


	/**
	 * In general, the height of a tree is one more than the maximum of the
	 * heights of the left and right subtrees.
	 * 
	 * @param root
	 * @return
	 */
	private int getTreeHeight(Node<E> root) {

		if (root == null) {
			return -1;
		} else {
			return 1 + Math.max(this.getTreeHeight(root.left), this.getTreeHeight(root.right));
		}

	}

	/**
	 * The depth of a node is the length of the unique path from the root to
	 * that node.
	 * 
	 * @param element
	 * @return
	 */
	public int getDepth(Node<E> node) {
		return this.getLevel(node);
	}

	/**
	 * The depth of a node is the length of the unique path from the root to
	 * that node.
	 * 
	 * @param element
	 * @return
	 */
	public int getDepth(E element) {
		return this.getLevel(this.findNode(root, element));
	}

	private int getLevel(Node<E> node) {
		int comp = 0;
		comp = (((Comparable) node.element).compareTo(root.element));

		if (comp == 0) {
			return 0;
		} else {
			return 1 + getLevel(node.parent);
		}

	}

	private Node<E> findLowestCommonAncestor(Node<E> root, E value1, E value2) {

		if (root == null) {
			return null;
		}

		int comp1 = 0;
		int comp2 = 0;

		comp1 = (((Comparable) value1).compareTo(root.element));
		comp2 = (((Comparable) value2).compareTo(root.element));

		if (comp1 < 0 && comp2 < 0) {
			return findLowestCommonAncestor(root.left, value1, value2);
		} else if (comp1 > 0 && comp2 > 0) {
			return findLowestCommonAncestor(root.right, value1, value2);
		} else {
			return root;
		}
	}

	protected static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		Node<E> parent;

		public Node() {
		}

		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}

		public Node(E element) {
			this.element = element;
		}
	}

	public void traverse(Traversal traversal) {
		this.traverse(root, traversal);
	}

	public void traverse(Node<E> node, Traversal traversal) {
		if (traversal == Traversal.INORDER) {
			System.out.println("-----------INORDER----------");
			this.traversalInOrder(node);
		} else if (traversal == Traversal.POSTORDER) {
			System.out.println("");
			System.out.println("-----------POSTORDER----------");
			this.traversalPostOrder(node);
		} else if (traversal == Traversal.PREORDER) {
			System.out.println("");
			System.out.println("-----------PREORDER----------");
			this.traversalPreOrderStack(node);
		}
	}

	private void traversalInOrder(Node<E> node) {

		if (node == null) {
			return;
		} else {
			traversalInOrder(node.left);
			System.out.print(node.element + ",");
			traversalInOrder(node.right);
		}
	}

	private void traversalPostOrder(Node<E> node) {

		if (node == null) {
			return;
		} else {
			traversalPostOrder(node.left);
			traversalPostOrder(node.right);
			System.out.print(node.element + ",");
		}
	}

	private void traversalPreOrder(Node<E> node) {

		if (node == null) {
			return;
		} else {
			System.out.print(node.element + ",");
			traversalPreOrder(node.left);
			traversalPreOrder(node.right);
		}
	}

	private void traversalPreOrderStack(Node<E> root) {

		if (root == null) {
			return;
		} else {
			Stack<Node<E>> stack = new Stack<Node<E>>();
			Node<E> currentNode = null;

			stack.push(root);

			while (stack.size() > 0) {
				currentNode = stack.pop();
				System.out.print(currentNode.element + ",");
				if (currentNode.right != null) {
					stack.push(currentNode.right);
				}
				if (currentNode.left != null) {
					stack.push(currentNode.left);
				}
			}

		}
	}

	public int getSize() {
		size = 0;
		this.preOrderSize(root);
		return size;
	}

	private void preOrderSize(Node<E> node) {
		if (node == null) {
			return;
		} else {
			size++;
			preOrderSize(node.left);
			preOrderSize(node.right);
		}
	}

	/**
	 * Uses a Breadth First Search (BFS) traversal. O(n) - Linear time
	 * 
	 * @param tree
	 * @return
	 */
	public int[] converteTreeToArray(BinaryTree<Integer> tree) {
		Queue<Node<Integer>> q = new LinkedList<Node<Integer>>();
		int[] a = new int[tree.getSize()];
		q.add((Node<Integer>) root);
		Node<Integer> node = null;

		int i = 0;
		while (q.size() > 0) {
			node = q.poll();
			a[i] = node.element;

			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
			i++;
		}

		return a;
	}

	private Node<Integer> addToTree(int [] array, int start, int end){
		if(end < start){
			return null;
		}
		
		int mid = (start+end)/2;
		Node<Integer> node = new Node<Integer>(array[mid]);
		node.left = addToTree(array, start, mid-1);
		node.right = addToTree(array, mid+1,end);
		return node;
	}

	private Node<Integer> sortedListToBSTRecur(com.studies.linkedList.singly.NodeLinkedList<Integer> nodeLinkedList, int n){
		
		/* Base Case */
		if(n<=0){
			return null;
		}
		
		/* Recursively construct the left subtree */
		Node<Integer> left = sortedListToBSTRecur(nodeLinkedList, n>>1);

		Node<Integer> root = new Node<Integer>(nodeLinkedList.getElement());
		
		root.left = left;
		
		 /* Change head pointer of Linked List for parent recursive calls */
		nodeLinkedList = nodeLinkedList.getNextNode();
		

	    /* Recursively construct the right subtree and link it with root
	      The number of nodes in right subtree  is total nodes - nodes in
	      left subtree - 1 (for root) which is n-n/2-1*/
		Node<Integer> right = sortedListToBSTRecur(nodeLinkedList, n-(n>>1)-1);
		root.right = right;
		return root;
	}

	private int countNodesOfLinkedList(com.studies.linkedList.singly.NodeLinkedList<Integer> node){
		if(node == null){
			return 0;
		}else{
			return 1+ countNodesOfLinkedList(node.getNextNode());
		}
	}
	
	public BinaryTree<Node<Integer>> createMininalBST(SinglyLinkedList<Integer> linkedList){
		return new BinaryTree(this.sortedListToBSTRecur(linkedList.getHead(),this.countNodesOfLinkedList(linkedList.getHead())));
	}

	public BinaryTree<Node<Integer>> createMininalBST(int[] array){
		return new BinaryTree(this.addToTree(array, 0, array.length-1));
	}
	
	protected Node<E> successor(Node<E> node) {
		if (node == null) {
			return null;
		} else if (node.right != null) {
			// successor is leftmost Entry in right subtree of e
			Node<E> p = node.right;
			while (p.left != null)
				p = p.left;
			return p;
		} else {
			// go up the tree to the left as far as possible, then go up
			// to the right.
			Node<E> p = node.parent;
			Node<E> ch = node;
			while (p != null && ch == p.right) {
				ch = p;
				p = p.parent;
			} // while
			return p;
		} // e has no right child
	} // method successor

	protected Node<E> deleteEntry(Node<E> p) {
		// If p has two children, replace p’s element with p’s successor’s
		// element, then make p reference that successor.
		if (p.left != null && p.right != null) {
			Node<E> s = successor(p);
			p.element = s.element;
			p = s;
		} // p had two children
			// At this point, p has either no children or one child.
		Node<E> replacement;
		if (p.left != null)
			replacement = p.left;
		else
			replacement = p.right;
		// If p has at least one child, link replacement to p.parent.
		if (replacement != null) {
			replacement.parent = p.parent;
			if (p.parent == null)
				root = replacement;
			else if (p == p.parent.left)
				p.parent.left = replacement;
			else
				p.parent.right = replacement;
		} // p has at least one child
		else if (p.parent == null)
			root = null;
		else {
			if (p == p.parent.left)
				p.parent.left = null;
			else
				p.parent.right = null;
		} // p has a parent but no children
		return p;
	} // method deleteEntry

	public Iterator<E> iterator() {
		return new TreeIterator();
	}

	public String toString() {
		Iterator<E> i = iterator();
		if (!i.hasNext())
			return "[]";

		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (;;) {
			E e = i.next();
			sb.append(e == this ? "(this Collection)" : e);
			if (!i.hasNext())
				return sb.append(']').toString();
			sb.append(", ");
		}
	}

	protected class TreeIterator implements Iterator<E> {
		protected Node<E> lastReturned = null, next;

		/**
		 * Positions this TreeIterator to the smallest element, according to the
		 * Comparable interface, in the BinarySearchTree object. The
		 * worstTime(n) is O(n) and averageTime(n) is O(log n).
		 * 
		 */
		protected TreeIterator() {
			next = root;
			if (next != null)
				while (next.left != null)
					next = next.left;
		} // default constructor

		/**
		 * Determines if there are still some elements, in the BinarySearchTree
		 * object this TreeIterator object is iterating over, that have not been
		 * accessed by this TreeIterator object.
		 * 
		 * @return true – if there are still some elements that have not been
		 *         accessed by this TreeIterator object; otherwise, return
		 *         false.
		 * 
		 */
		public boolean hasNext() {
			return next != null;
		} // method hasNext

		/**
		 * Returns the element in the Entry this TreeIterator object was
		 * positioned at before this call, and advances this TreeIterator
		 * object. The worstTime(n) is O(n) and averageTime(n) is constant.
		 * 
		 * @return the element this TreeIterator object was positioned at before
		 *         this call.
		 * 
		 * @throws NoSuchElementException
		 *             – if this TreeIterator object was not positioned at an
		 *             Entry before this call.
		 * 
		 */
		public E next() {
			if (next == null)
				throw new NoSuchElementException();
			lastReturned = next;
			next = successor(next);
			return lastReturned.element;
		} // method next

		/**
		 * Removes the element returned by the most recent call to this
		 * TreeIterator object’s next() method. The worstTime(n) is O(n) and
		 * averageTime(n) is constant. *
		 * 
		 * @throws IllegalStateException
		 *             – if this TreeIterator’s next() method was not called
		 *             before this call, or if this TreeIterator’s remove()
		 *             method was called between the call to the next() method
		 *             and this call.
		 * 
		 */
		public void remove() {
			if (lastReturned == null)
				throw new IllegalStateException();
			if (lastReturned.left != null && lastReturned.right != null)
				next = lastReturned;
			deleteEntry(lastReturned);
			lastReturned = null;
		}
	}

	public List<SinglyLinkedList<Node<E>>> createLinkedListAtDepth(BinaryTree<E> binaryTree){
		List<SinglyLinkedList<Node<E>>> list = new ArrayList<SinglyLinkedList<Node<E>>>();
		SinglyLinkedList<Node<E>> link = null;
		LinkedList<Node<E>> queue = new LinkedList<Node<E>>();
		int currLevel = -1;
		queue.add(binaryTree.root);
		Node<E> node = null;
		
		//BFS
		while(queue.size() > 0){
			node = queue.poll();
			int nodeLevel = binaryTree.getDepth(node);
			if(nodeLevel != currLevel){
				currLevel = nodeLevel;
				
				if(link!=null){
					list.add(link);
				}
				
				link = new SinglyLinkedList<Node<E>>();
				link.insertElement(node);
			}else{//same level
				link.insertElement(node);
			}
			
			if(node.left!=null){
				queue.add(node.left);
			}

			if(node.right!=null){
				queue.add(node.right);
			}
		}
		
		list.add(link);
		
		return list;
	}
	
	public Node<E> findNextBiggerNumber(E number){
		Node<E> node = this.findNode(number);
		return this.findInorderSuccessor(node);
	}
	
	public Node<E> findInorderSuccessor(Node<E> node){
		if(node == null){
			throw new RuntimeException("The node provided is null");
		}
		
		//1st case - right subtree is not null
		//If the right subtree is not null, so the inorder successor is the leftmost child
		if(node.right!=null){
			return minValue(node.right);
		}
		
		//2nd case - right subtree is NULL, so we navigate the parent up
		Node<E> parent = node.parent;
		while(parent!= null && node == parent.right){
			node = parent;
			parent = parent.parent;
		}
		
		return parent;
	}
	
	private Node<E> minValue(Node<E> node){
		Node<E> current = node;
		
		while(node.left!=null){
			current = node.left;
			node = node.left;
		}
		
		return current;
	}
	
	public boolean isStructurallyIdentical(Node<E> node1, Node<E> node2){
		if(node1 == null && node2 == null){
			return true;
		}else if(node1 != null && node2 != null){
			return isStructurallyIdentical(node1.left, node2.left) && isStructurallyIdentical(node1.right, node2.right);
		}else{
			return false;
		}
	}

	public boolean isSame(Node<E> node1, Node<E> node2){
		if(node1 == null && node2 == null){
			return true;
		}else if(node1 != null && node2 != null){
			return node1.element == node2.element && isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
		}else{
			return false;
		}
	}
	
	public boolean containsPathToSum(Node<Integer> node, int sum){
		boolean ret = this.contains(node, sum, 0);
		return ret;
	}
	
	public boolean contains(Node<Integer> node, int sum, int sumNode){
		if (node == null){
			if(sum == sumNode){
				return true;
			}else{
				return false;
			}
		}
		
		boolean ret = false;
		sumNode += node.element;
		
		ret = this.contains(node.left, sum, sumNode);
		
		if(ret){
			return true;
		}

		ret = this.contains(node.right, sum, sumNode);
		
		if(ret){
			return true;
		}
		
		return false;
	}
	
	public void printPathDiv5(BinaryTree<Integer> tree){
		printPathDiv5(tree.root, new int[1000],0);
	}
	
	private void printPathDiv5(Node<Integer> node,int[ ] path, int pathLength){
		if(node == null){
			return;
		}
		
		path[ pathLength++ ] =node.element;
		
		if(node.element%5 == 0){
			printPath(path,pathLength);
		}
		
		printPathDiv5(node.left, path,pathLength);
		printPathDiv5(node.right, path,pathLength);
		
	}
	
	 private static void printPath( int[ ] path, int pathLength ) {
	        for( int i = 0; i < pathLength; i++ ) {
	            System.out.print( path[ i ] );
	            if( i + 1 < pathLength ) {
	                System.out.print( " -> " );
	            }
	        }
	        System.out.println( );
	    }	
}
