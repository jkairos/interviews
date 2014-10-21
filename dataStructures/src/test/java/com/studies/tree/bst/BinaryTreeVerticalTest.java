package com.studies.tree.bst;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeVerticalTest {

	//@Test
	public void testVerticalSum() {
		BinaryTreeVertical binaryTreeVerticalSum = new BinaryTreeVertical();
		BinaryTree.Node<Integer> rootNode = new BinaryTree.Node<Integer>(1); 
		
		BinaryTree.Node<Integer> n1Left = new BinaryTree.Node<Integer>(2); 
		BinaryTree.Node<Integer> n1LeftLeft = new BinaryTree.Node<Integer>(4); 
		BinaryTree.Node<Integer> n1RightRight = new BinaryTree.Node<Integer>(5);
		n1Left.left = n1LeftLeft;
		n1Left.right = n1RightRight;

		BinaryTree.Node<Integer> n2Right = new BinaryTree.Node<Integer>(3); 
		BinaryTree.Node<Integer> n2RightLeft = new BinaryTree.Node<Integer>(6); 
		BinaryTree.Node<Integer> n2RightRight = new BinaryTree.Node<Integer>(7);
		n2Right.left = n2RightLeft;
		n2Right.right = n2RightRight;
		
		rootNode.left = n1Left;
		rootNode.right = n2Right;
		
		binaryTreeVerticalSum.printVerticalSum(rootNode);
	}
	
	@Test
	public void testVertical() {
		BinaryTreeVertical binaryTreeVerticalSum = new BinaryTreeVertical();
		BinaryTree.Node<Integer> rootNode = new BinaryTree.Node<Integer>(1); 
		
		BinaryTree.Node<Integer> n1Left = new BinaryTree.Node<Integer>(2); 
		BinaryTree.Node<Integer> n1LeftLeft = new BinaryTree.Node<Integer>(4); 
		n1Left.left = n1LeftLeft;
		
		BinaryTree.Node<Integer> n2Right = new BinaryTree.Node<Integer>(3); 
		BinaryTree.Node<Integer> n2RightLeft = new BinaryTree.Node<Integer>(5); 
		BinaryTree.Node<Integer> n2RightRight = new BinaryTree.Node<Integer>(6);
		n2RightLeft.right = n2RightRight;
		
		n2Right.left = n2RightLeft;
		
		rootNode.left = n1Left;
		rootNode.right = n2Right;
		
		binaryTreeVerticalSum.printVerticalNodes(rootNode);
	}

}
