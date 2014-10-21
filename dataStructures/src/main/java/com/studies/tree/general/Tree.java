package com.studies.tree.general;

import java.util.List;

public interface Tree<E> {
	public Node<E> getRoot();
	public Node<E> getParent(Node<E> node);
	public List<Node<E>> getChildren(Node<E> node);
	public boolean isInternal(Node<E> node);
	public boolean isLeaf(Node<E> node);
	public boolean isRoot(Node<E> node);
	public int size();
	public boolean isEmpty();
	public String traverse(Traversal traversal);
	public int getHeight();
}
