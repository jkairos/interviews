package com.studies.util;

import com.studies.tree.bst.BinaryTree;

public class TreeUtils {
	
	private TreeUtils(){}
	
	// O(n log n)
	public static int[] buildHeap(BinaryTree<Integer> tree){
		int[] a = converteTree(tree);//O(n)
		int latestParentNode = a.length/2 -1;
		for (int i = latestParentNode; i >= 0; i--) {
			heapify(a, i);//O(log n)
		}
		
		return a;
	}
	
	private static int[] converteTree(BinaryTree<Integer> tree){
		return tree.converteTreeToArray(tree);
	}
	
	//O(log n)
	private static void heapify(int[] array, int idx){
		int lIdx = 2*idx+1;
		int rIdx = 2*idx+2;
		int smallest = idx;
		
		if(lIdx < array.length && array[lIdx] < array[smallest]){
			smallest = lIdx;
		}

		if(rIdx < array.length && array[rIdx] < array[smallest]){
			smallest = rIdx;
		}
		
		if(smallest!=idx){
			swap(array, idx, smallest);
			heapify(array, smallest);
		}
		
	}
	
	private static void swap(int[] array, int old, int newIdx){
		int aux = array[old];
		array[old] = array[newIdx];
		array[newIdx] = aux;
	}
}
