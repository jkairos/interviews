package com.studies.tree.bst;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class BinaryTreeVertical {
	private Map<Integer, Integer> verticalSum = new HashMap<Integer, Integer>();
	private Map<Coordinates, Integer> map = new TreeMap<Coordinates, Integer>();
	
	public void printVerticalSum(BinaryTree.Node<Integer> node){
		this.findVerticalSum(node, 0);
		
		for(Entry<Integer, Integer> entry : verticalSum.entrySet()){
			System.out.print(entry.getValue() + ",");
		}
	}
	
	private void findVerticalSum(BinaryTree.Node<Integer> node, int hd){
		if(node == null){
			return;
		}
		
		if(verticalSum.containsKey(hd)){
			verticalSum.put(hd, verticalSum.get(hd)+node.element);
		}else{
			verticalSum.put(hd, node.element);
		}
		
		findVerticalSum(node.left, hd-1);
		findVerticalSum(node.right, hd+1);
	}
	
	public void printVerticalNodes(BinaryTree.Node<Integer> node){
		this.buildMap(node, 0,0);
		
		for(Entry<Coordinates, Integer> entry : map.entrySet()){
			System.out.print(entry.getValue() + ",");
		}
	}
	
	private void buildMap(BinaryTree.Node<Integer> node, int hd, int axis){
		if(node == null){
			return;
		}
		
		map.put(new Coordinates(hd, axis), node.element);
		
		buildMap(node.left, hd-1, axis+1);
		buildMap(node.right, hd+1, axis+1);
	}
}
