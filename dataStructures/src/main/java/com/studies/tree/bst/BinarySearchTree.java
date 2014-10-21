package com.studies.tree.bst;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author jkairos
 * 
 */
public class BinarySearchTree<E> extends AbstractSet<E> {
	protected Entry<E> root;
	protected int size;

	public BinarySearchTree() {
		root = null;
		size = 0;
	}

	public BinarySearchTree(BinarySearchTree<? extends E> otherTree) {
		root = copy(otherTree.root, null);
		size = otherTree.size;
	} // copy constructor

	protected Entry<E> copy(Entry<? extends E> p, Entry<E> parent) {
		if (p != null) {
			Entry<E> q = new Entry<E>(p.element, parent);
			q.left = copy(p.left, q);
			q.right = copy(p.right, q);
			return q;
		} // if
		return null;
	} // method copy

	public boolean contains(Object obj) {
		return this.getEntry(obj) != null;
	} // method contains

	public Entry<E> getEntry(Object obj) {
		Entry<E> temp = root;
		int comp;
		Entry<E> entry = null;

		if (obj == null) {
			throw new NullPointerException();
		}

		while (temp != null) {
			comp = ((Comparable) obj).compareTo(temp.element);
			if (comp == 0) {
				entry = temp;
			} else if (comp < 0) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		} // while
		return entry;

	}

	public boolean add(E element) {
		if (root == null) {// empty tree
			if (element == null)
				throw new NullPointerException();
			root = new Entry<E>(element, null);
			size++;
			return true;
		} else {
			Entry<E> temp = root;
			int comp;
			while (true) {
				comp = ((Comparable) element).compareTo(temp.element);
				if (comp == 0)
					return false;
				if (comp < 0)
					if (temp.left != null)
						temp = temp.left;
					else {
						temp.left = new Entry<E>(element, temp);
						size++;
						return true;
					} // temp.left == null
				else if (temp.right != null)
					temp = temp.right;
				else {
					temp.right = new Entry<E>(element, temp);
					size++;
					return true;
				} // temp.right == null
			} // while
		} // root not null
	} // method add

	public boolean remove(Object obj) {
		Entry<E> e = getEntry(obj);
		if (e == null)
			return false;
		deleteEntry(e);
		return true;
	} // method remove

	protected Entry<E> deleteEntry(Entry<E> p) {
		this.size--;
		// If p has two children, replace p’s element with p’s successor’s
		// element, then make p reference that successor.
		if (p.left != null && p.right != null) {
			Entry<E> s = successor(p);
			p.element = s.element;
			p = s;
		} // p had two children
			// At this point, p has either no children or one child.
		Entry<E> replacement;
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

	protected Entry<E> successor(Entry<E> e) {
		if (e == null)
			return null;
		else if (e.right != null) {
			// successor is leftmost Entry in right subtree of e
			Entry<E> p = e.right;
			while (p.left != null)
				p = p.left;
			return p;
		} // e has a right child
		else {
			// go up the tree to the left as far as possible, then go up
			// to the right.
			Entry<E> p = e.parent;
			Entry<E> ch = e;
			while (p != null && ch == p.right) {
				ch = p;
				p = p.parent;
			} // while
			return p;
		} // e has no right child
	} // method successor

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	protected static class Entry<E> {
		E element;
		Entry<E> left;
		Entry<E> right;
		Entry<E> parent;

		public Entry() {
		}

		public Entry(E element, Entry<E> parent) {
			this.element = element;
			this.parent = parent;
		}
	}

	protected class TreeIterator implements Iterator<E> {
		protected Entry<E> lastReturned = null, next;

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
		 * Removes the element returned by the most recent call to this TreeIterator
		 * object’s next() method. The worstTime(n) is O(n) and averageTime(n) is
		 * constant. *
		 * 
		 * @throws IllegalStateException
		 *             – if this TreeIterator’s next() method was not called before
		 *             this call, or if this TreeIterator’s remove() method was
		 *             called between the call to the next() method and this call.
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
}
