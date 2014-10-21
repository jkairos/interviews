package com.studies.tree.general;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TreeTest {
	private Tree<String> tree;

	@Before
	public void setUp() throws Exception {
		List<Node<String>> children = new ArrayList<Node<String>>();

		Node<String> root = new Node<String>("A");
		
		Node<String> n1 = new Node<String>("B",root,null);
		
		Node<String> n11 = new Node<String>("C",n1,null);

		Node<String> n12 = new Node<String>("D",n1,null);
		Node<String> n121 = new Node<String>("E",n12,null);
		Node<String> n122 = new Node<String>("F",n12,null);
		children.add(n121);
		children.add(n122);
		n12.setChildren(children);
		
		Node<String> n13 = new Node<String>("G",n1,null);
		Node<String> n131 = new Node<String>("H",n13,null);
		Node<String> n132 = new Node<String>("I",n13,null);
		children = new ArrayList<Node<String>>();
		children.add(n131);
		children.add(n132);
		n13.setChildren(children);

		children = new ArrayList<Node<String>>();
		children.add(n11);
		children.add(n12);
		children.add(n13);
		n1.setChildren(children);
		
		Node<String> n2 = new Node<String>("J",root,null);
		
		Node<String> n21 = new Node<String>("K",n2,null);
		Node<String> n211 = new Node<String>("L",n21,null);
		Node<String> n212 = new Node<String>("M",n21,null);

		children = new ArrayList<Node<String>>();
		children.add(n211);
		children.add(n212);
		n21.setChildren(children);

		Node<String> n22 = new Node<String>("N",n2,null);
		
		children = new ArrayList<Node<String>>();
		children.add(n21);
		children.add(n22);
		n2.setChildren(children);

		children = new ArrayList<Node<String>>();
		children.add(n1);
		children.add(n2);
		root.setChildren(children);
		
		tree = new TreeImpl<String>(root);
}

	@Test
	public void testTraversePreOrder(){
		assertEquals("A, B, C, D, E, F, G, H, I, J, K, L, M, N", tree.traverse(Traversal.PRE_ORDER));
	}
	
	@Test
	public void testTraversePostOrder(){
		assertEquals("C, E, F, D, H, I, G, B, L, M, K, N, J, A", tree.traverse(Traversal.POST_ORDER));
	}
	
	@Test
	public void testHeight(){
		assertEquals(3, tree.getHeight());
	}
}
