package com.studies.tree.bst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

	protected BinarySearchTree<String> tree;

	//@Before
	public void setUp() throws Exception {
		tree = new BinarySearchTree<String>();
	}

	//@Test
	public void testAdd() {
		tree.add("b");
		tree.add("a");
		tree.add("c");
		tree.add("e");
		tree.add("c");
		tree.add("d");
		assertEquals("[a, b, c, d, e]", tree.toString());
	} // method testAdd

	//@Test
	public void testContains() {
		tree.add("a");
		tree.add("b");
		tree.add("c");
		assertEquals(true, tree.contains("a"));
		assertEquals(true, tree.contains("b"));
		assertEquals(true, tree.contains("c"));
		assertEquals(false, tree.contains("x"));
		assertEquals(false, tree.contains(""));
	} // method testContains

	//@Test(expected = NullPointerException.class)
	public void testContainsNull() {
		tree.add("a");
		tree.add("b");
		tree.add("c");
		tree.contains(null);
	} // method testContainsNull

	//@Test
	public void testRemove() {
		tree.add("b");
		tree.add("a");
		tree.add("c");
		assertEquals(true, tree.remove("b"));
		assertEquals(2, tree.size());
		assertEquals(false, tree.remove("b"));
		assertEquals(2, tree.size());
	} // method testRemove
}
