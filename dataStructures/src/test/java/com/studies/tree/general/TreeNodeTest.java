package com.studies.tree.general;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TreeNodeTest {

	private TreeNode<String> root;
	
	@Before
	public void setUp(){
		root = new TreeNode<String>("A");
		TreeNode<String> parent = new TreeNode<String>("B");

		root.add(parent);
		parent.add(new TreeNode<String>("E"));
		parent.add(new TreeNode<String>("F"));

		parent = new TreeNode<String>("C");
		root.add(parent);
		TreeNode<String> parentG = new TreeNode<String>("G");
		parent.add(parentG);

		parentG.add(new TreeNode<String>("H"));
		
		parent = new TreeNode<String>("D");
		root.add(parent);
		
	}
	
	@Test
	public void test() {
		root.traverse();
	}
	
	@Test
	public void testFindNode(){
		assertEquals("H", root.findTreeNode(root.getRoot(), "H").getElement());
	}
	


}
