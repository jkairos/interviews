package com.studies.tree.bst;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.studies.linkedList.singly.SinglyLinkedList;
import com.studies.tree.bst.BinaryTree.Node;
import com.studies.util.TreeUtils;

public class BinaryTreeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
//		Node<Integer> rootNode = new Node<Integer>(5, null);
//		Node<Integer> nodeLeft = new Node<Integer>(3, rootNode);
//		Node<Integer> nodeRight = new Node<Integer>(10, rootNode);
//
//		Node<Integer> node1_1 = new Node<Integer>(1, nodeLeft);
//		Node<Integer> node1_2 = new Node<Integer>(4, nodeLeft);
//
//		Node<Integer> node2_1 = new Node<Integer>(7, nodeRight);
//		Node<Integer> node2_2 = new Node<Integer>(12, nodeRight);
//		
//		nodeLeft.left = node1_1;
//		nodeLeft.right = node1_2;
//
//		nodeRight.left = node2_1;
//		nodeRight.right = node2_2;
//		
//		rootNode.left = nodeLeft;
//		rootNode.right = nodeRight;
		
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.add(5);
		tree.add(3);
		tree.add(10);
		tree.add(1);
		tree.add(4);
		tree.add(7);
		tree.add(12);
		
		System.out.println("To String: " + tree.toString());
		
		tree.traverse(Traversal.INORDER);
		tree.traverse(Traversal.POSTORDER);
		tree.traverse(Traversal.PREORDER);
		
		assertEquals("[1, 3, 4, 5, 7, 10, 12]", tree.toString());
		
	}
	
	@Test
	public void testLowestCommonAncestor(){
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(20);
		tree.add(22);
		tree.add(8);
		tree.add(4);
		tree.add(12);
		tree.add(10);
		tree.add(14);
		assertEquals(Integer.valueOf(8), tree.findLowestCommonAncestor(tree.root, tree.findNode(4), tree.findNode(14)).element);
		assertEquals(Integer.valueOf(20), tree.findLowestCommonAncestor(tree.root, tree.findNode(4), tree.findNode(22)).element);
		
	}

	@Test
	public void testTreeHeight(){
		BinaryTree<String> tree = new BinaryTree<String>();
		
		tree.add("E");
		tree.add("T");
		tree.add("I");
		tree.add("A");
		tree.add("O");
		tree.add("N");
		tree.add("S");
		
		assertEquals(4, tree.getHeight());

		BinaryTree<String> tree1 = new BinaryTree<String>();
		
		tree1.add("E");
		tree1.add("T");
		tree1.add("A");
		
		assertEquals(1, tree1.getHeight());
	}
	
	@Test
	public void testDepth(){
		BinaryTree<String> tree = new BinaryTree<String>();
		
		tree.add("E");
		tree.add("T");
		tree.add("I");
		tree.add("A");
		tree.add("O");
		tree.add("N");
		tree.add("S");
		
		assertEquals(3, tree.getDepth("O"));
		assertEquals(0, tree.getDepth("E"));
		
	}

	@Test
	public void testLeaves(){
		BinaryTree<String> tree = new BinaryTree<String>();
		
		tree.add("E");
		tree.add("T");
		tree.add("I");
		tree.add("A");
		tree.add("O");
		tree.add("N");
		tree.add("S");
		
		assertEquals(3, tree.getAmountOfLeaves());
		
		BinaryTree<String> tree1 = new BinaryTree<String>();
		
		tree1.add("E");
		tree1.add("T");
		tree1.add("A");
		
		assertEquals(2, tree1.getAmountOfLeaves());

		BinaryTree<String> tree2 = new BinaryTree<String>();
		
		assertEquals(0, tree2.getAmountOfLeaves());
	}
	
	@Test
	public void testBuildHeap(){
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(20);
		tree.add(8);
		tree.add(22);
		tree.add(4);
		tree.add(12);
		tree.add(10);
		tree.add(14);
		
		int[] heap = TreeUtils.buildHeap(tree);
		int[] expected = {4,8,10,20,12,22,14};
		
		assertArrayEquals(expected,heap);
		
	}
	
	@Test
	public void testCreateMininalBST(){
//		int array[] = {1,3,6,9,20,25,28,30,35};
		int array[] = {1,3,6,9};
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		BinaryTree<Node<Integer>> n = tree.createMininalBST(array);
		n.traverse(Traversal.PREORDER);
		assertTrue(n.isBalanced());
		assertEquals(2, n.getHeight());
	}

	@Test
	public void testCreateMininalBSTLinkedList(){
//		int array[] = {1,3,6,9,20,25,28,30,35};
		
		SinglyLinkedList<Integer> linked = new SinglyLinkedList<Integer>();
		linked.insertElement(1);
		linked.insertElement(3);
		linked.insertElement(6);
		linked.insertElement(9);
		
		
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		BinaryTree<Node<Integer>> n = tree.createMininalBST(linked);
		n.traverse(Traversal.PREORDER);
		assertTrue(n.isBalanced());
		assertEquals(2, n.getHeight());
	}
	
	
	@Test
	public void testCreateLinkedListAtDepth(){
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(10);
		tree.add(8);
		tree.add(12);
		tree.add(6);
		tree.add(9);
		tree.add(11);
		tree.add(15);
		tree.add(4);

		tree.traverse(Traversal.INORDER);
		
		List<SinglyLinkedList<Node<Integer>>> list = tree.createLinkedListAtDepth(tree);
		assertEquals(4, list.size());
	}

	@Test
	public void testCreateLinkedListAtDepth2(){
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(10);
		tree.add(8);
		tree.add(12);
		tree.add(6);
		tree.add(9);
		tree.add(11);
		tree.add(15);
		List<SinglyLinkedList<Node<Integer>>> list = tree.createLinkedListAtDepth(tree);
		assertEquals(3, list.size());
	}
	
	@Test
	public void testFindInorderSuccessor(){
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(20);
		tree.add(8);
		tree.add(4);
		tree.add(12);
		tree.add(10);
		tree.add(14);
		tree.add(22);
		
		Node<Integer> node =tree.findNode(4);
		assertEquals(Integer.valueOf(8),tree.findInorderSuccessor(node).element);

		Node<Integer> node1 =tree.findNode(14);
		assertEquals(Integer.valueOf(20),tree.findInorderSuccessor(node1).element);

		Node<Integer> node2 =tree.findNode(12);
		assertEquals(Integer.valueOf(14),tree.findInorderSuccessor(node2).element);
	}

	@Test
	public void testLowestCommonAncestorBT(){
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(20);
		tree.add(8);
		tree.add(4);
		tree.add(12);
		tree.add(10);
		tree.add(14);
		tree.add(22);
		assertEquals(Integer.valueOf(8), tree.findLowestCommonAncestorBT(tree.root, tree.findNode(4), tree.findNode(14)).element);
		assertEquals(Integer.valueOf(12), tree.findLowestCommonAncestorBT(tree.root, tree.findNode(10), tree.findNode(14)).element);
		
	}

	@Test
	public void testFindNextBiggerNumber(){
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(20);
		tree.add(8);
		tree.add(4);
		tree.add(12);
		tree.add(10);
		tree.add(14);
		tree.add(22);
		assertEquals(Integer.valueOf(20), tree.findNextBiggerNumber(14).element);
		
	}

	@Test
	public void testFindNextBiggerNumber2(){
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(20);
		tree.add(8);
		tree.add(4);
		tree.add(12);
		tree.add(10);
		tree.add(14);
		tree.add(22);
		assertEquals(Integer.valueOf(22), tree.findNextBiggerNumber(20).element);
		
	}

	@Test
	public void testFindNextBiggerNumber3(){
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(20);
		tree.add(8);
		tree.add(4);
		tree.add(12);
		tree.add(10);
		tree.add(14);
		tree.add(22);
		assertEquals(Integer.valueOf(20), tree.findNextBiggerNumber(14).element);
		
	}

	@Test
	public void testIsStructurallyIdentical(){
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(20);
		tree.add(8);
		tree.add(4);
		tree.add(12);
		tree.add(10);
		tree.add(14);
		tree.add(22);

		BinaryTree<Integer> tree1 = new BinaryTree<Integer>();
		
		tree1.add(20);
		tree1.add(8);
		tree1.add(4);
		tree1.add(12);
		tree1.add(10);
		tree1.add(14);
		tree1.add(22);
		assertEquals(true,tree.isStructurallyIdentical(tree.root, tree1.root));
		
	}

	@Test
	public void testIsSame(){
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(20);
		tree.add(8);
		tree.add(4);
		tree.add(12);
		tree.add(10);
		tree.add(14);
		tree.add(22);
		
		BinaryTree<Integer> tree1 = new BinaryTree<Integer>();
		
		tree1.add(20);
		tree1.add(8);
		tree1.add(4);
		tree1.add(12);
		tree1.add(10);
		tree1.add(14);
		tree1.add(22);
		assertEquals(true,tree.isSame(tree.root, tree1.root));
		
	}
	
	@Test
	public void testContainsPathToSum(){
		
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(20);
		tree.add(8);
		tree.add(4);
		tree.add(12);
		tree.add(10);
		tree.add(14);
		tree.add(22);
		assertEquals(true,tree.containsPathToSum(tree.root, 32));
	}
	
	@Test
	public void testContainsPathToSum1(){
		
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(20);
		tree.add(8);
		tree.add(4);
		tree.add(12);
		tree.add(10);
		tree.add(14);
		tree.add(22);
		assertEquals(true,tree.containsPathToSum(tree.root, 50));
	}
	@Test
	public void testContainsPathToSum2(){
		
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(20);
		tree.add(8);
		tree.add(4);
		tree.add(12);
		tree.add(10);
		tree.add(14);
		tree.add(22);
		assertEquals(true,tree.containsPathToSum(tree.root, 54));
	}
	@Test
	public void testContainsPathToSum3(){
		
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(20);
		tree.add(8);
		tree.add(4);
		tree.add(12);
		tree.add(10);
		tree.add(14);
		tree.add(22);
		assertEquals(true,tree.containsPathToSum(tree.root, 42));
	}
	
	@Test
	public void testContainsPathToSum4(){
		
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(20);
		tree.add(8);
		tree.add(4);
		tree.add(12);
		tree.add(10);
		tree.add(14);
		tree.add(22);
		assertEquals(false,tree.containsPathToSum(tree.root, 323));
	}

	@Test
	public void testPrintPatbDiv5(){
		
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(10);
		tree.add(8);
		tree.add(12);
		tree.add(15);
		tree.add(5);
		tree.add(20);
		tree.add(13);
		tree.add(25);
		
		tree.printPathDiv5(tree);
	}
}
