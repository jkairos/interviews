package com.studies.tree.general;

import java.util.Enumeration;
import java.util.Vector;

public class TreeNode<E> {

	private E element;
	private TreeNode<E> parent;
	private Vector<TreeNode<E>> children;

	public TreeNode(E element) {
		this.element = element;
		this.parent = null;
	}

	public void add(TreeNode<E> newChild) {
		TreeNode<E> oldParent = newChild.getParent();

		if (oldParent != null) {
			oldParent.remove(newChild);
		}

		newChild.setParent(this);

		if (children == null) {
			children = new Vector<TreeNode<E>>();
		}
		children.add(newChild);
	} // method add

	public void remove(TreeNode<E> aChild) {
		if (aChild == null) {
			throw new IllegalArgumentException("argument is null");
		}

		this.children.remove(getIndex(aChild)); // linear search
	}

	public int getIndex(TreeNode<E> aChild) {
		if (aChild == null) {
			throw new IllegalArgumentException("argument is null");
		}

		return this.children.indexOf(aChild); // linear search
	}

	public TreeNode<E> getParent() {
		return parent;
	}

	public void setParent(TreeNode<E> parent) {
		this.parent = parent;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

    public boolean isLeaf(TreeNode<E> node) {
        return node.isLeaf();
    }	
	
	public boolean isLeaf() {
		return (getChildCount() == 0);
	}

	public int getChildCount() {
		if (children == null) {
			return 0;
		} else {
			return children.size();
		}
	}

    public int getChildCount(TreeNode<E> parent) {
        return parent.getChildCount();
    }
	
    public TreeNode<E> getChild(TreeNode<E> parent, int index) {
        return parent.getChildAt(index);
    }

    public TreeNode<E> getChildAt(int index) {
    	if (children == null) {
    		throw new ArrayIndexOutOfBoundsException("node has no children");
    	}
    	return children.elementAt(index);
    }

    public TreeNode<E> getRoot() {
		TreeNode<E> ancestor = this;
		TreeNode<E> previous;

		do {
			previous = ancestor;
			ancestor = ancestor.getParent();
		} while (ancestor != null);

		return previous;
	}

	public Enumeration<TreeNode<E>> getChildren() {
		return children.elements();
	}

	public TreeNode<E> findTreeNode(TreeNode<E> root, E element) {
		int comp = 0;

		if (root == null) {
			return null;
		}else{
			return this.findNode(root, element);
			
		}
	}
	
	public TreeNode<E> findNode(TreeNode<E> node, E element){
		int  childCount;
		childCount = this.getChildCount(node);

		int comp = 0;
		comp = (((Comparable) element).compareTo(node.element));

		for( int i=0; i < childCount; i++) {
	    	TreeNode<E> child = this.getChild(node, i );
	        if (this.isLeaf(child)){
	    		if (comp == 0) {
	    			return child;
	    		}
	        }else {
	        	return this.findNode(child,element);
	        }
	   } 
		
		return null;
		
	}

//	public TreeNode<E> findLowestCommonAncestor(TreeNode<E> root, TreeNode<E> child1, TreeNode<E> child2) {
//		if (root == null || child1 == null || child2 == null) {
//			return null;
//		} else {
//			return this.findLowestCommonAncestor(root, child1.element, child2.element);
//		}
//	}

//	public int getAmountOfLeaves() {
//		return this.getAmountOfLeaves(this.getRoot());
//	}
//
//	private int getAmountOfLeaves(TreeNode<E> root) {
//		if (root == null) {
//			return 0;
//		} else if (root.left == null && root.right == null) {
//			return 1;
//		} else {
//			return this.getAmountOfLeaves(root.left) + this.getAmountOfLeaves(root.right);
//		}
//	}

//	public int getHeight() {
//		return this.getTreeHeight(root);
//	}

	/**
	 * In general, the height of a tree is one more than the maximum of the
	 * heights of the left and right subtrees.
	 * 
	 * @param root
	 * @return
	 */
//	private int getTreeHeight(TreeNode<E> root) {
//
//		if (root == null) {
//			return -1;
//		} else {
//			return 1 + Math.max(this.getTreeHeight(root.left), this.getTreeHeight(root.right));
//		}
//
//	}

	/**
	 * The depth of a node is the length of the unique path from the root to
	 * that node.
	 * 
	 * @param element
	 * @return
	 */
	public int getDepth(E element) {
		return this.getLevel(this.findTreeNode(this.getRoot(), element));
	}

	private int getLevel(TreeNode<E> node) {
		int comp = 0;
		comp = (((Comparable) node.element).compareTo(this.getRoot().element));

		if (comp == 0) {
			return 0;
		} else {
			return 1 + getLevel(node.parent);
		}

	}

//	private TreeNode<E> findLowestCommonAncestor(TreeNode<E> root, E value1, E value2) {
//
//		if (root == null) {
//			return null;
//		}
//
//		int comp1 = 0;
//		int comp2 = 0;
//
//		comp1 = (((Comparable) value1).compareTo(root.element));
//		comp2 = (((Comparable) value2).compareTo(root.element));
//
//		if (comp1 < 0 && comp2 < 0) {
//			return findLowestCommonAncestor(root.left, value1, value2);
//		} else if (comp1 > 0 && comp2 > 0) {
//			return findLowestCommonAncestor(root.right, value1, value2);
//		} else {
//			return root;
//		}
//	}

	public void traverse() {
		System.out.println(this.getRoot().getElement());
		this.traverse(this.getRoot());
	}

	public void traverse(TreeNode<E> node) {
		int  childCount;
		childCount = this.getChildCount(node);

		for( int i=0; i < childCount; i++) {
	    	TreeNode<E> child = this.getChild(node, i );
	        if (this.isLeaf(child)){
	    		System.out.println(child.getElement());
	        }else {
	    		System.out.println(child.getElement()+"---");
	        	this.traverse(child);
	        }
	   } 
	}


//	public String toString() {
//		int  childCount;
//		childCount = this.getChildCount(this.getRoot());
//		
//		if(childCount == 0){
//			return "[]";
//		}else{
//			
//		}
//
//		StringBuilder sb = new StringBuilder();
//		sb.append('[');
//		
//		for( int i=0; i < childCount; i++) {
//	    	TreeNode<E> child = this.getChild(node, i );
//	        if (this.isLeaf(child)){
//	    		System.out.println(child.getElement());
//	        }else {
//	    		System.out.println(child.getElement()+"---");
//	        	this.traverse(child);
//	        }
//	   } 
//
//		
//		
//		Iterator<E> i = iterator();
//		if (!i.hasNext())
//			return "[]";
//
//		StringBuilder sb = new StringBuilder();
//		sb.append('[');
//		for (;;) {
//			E e = i.next();
//			sb.append(e == this ? "(this Collection)" : e);
//			if (!i.hasNext())
//				return sb.append(']').toString();
//			sb.append(", ");
//		}
//	}

}
