package com.studies.recursion;

import java.util.HashMap;
import java.util.Map;

public class NQueens {
	private static Map<Integer, Integer> rowMapping;
	private static Map<Integer, Character> columnMapping;
	private int[] config = new int[8];
	private int count;
	
	static{
		rowMapping = new HashMap<Integer, Integer>();
		rowMapping.put(0, 8);
		rowMapping.put(1, 7);
		rowMapping.put(2, 6);
		rowMapping.put(3, 5);
		rowMapping.put(4, 4);
		rowMapping.put(5, 3);
		rowMapping.put(6, 2);
		rowMapping.put(7, 1);
		
		columnMapping = new HashMap<Integer, Character>();
		columnMapping.put(0, 'a');
		columnMapping.put(1, 'b');
		columnMapping.put(2, 'c');
		columnMapping.put(3, 'd');
		columnMapping.put(4, 'e');
		columnMapping.put(5, 'f');
		columnMapping.put(6, 'g');
		columnMapping.put(7, 'h');
	}
	
	public void nQueens(int index, int len){
		for (int i = 0; i < len; i++) {
			if(isValidPosition(index, i)){
				config[index] = i;
				if(index == len-1){
					this.printBoard();
				}else{
					nQueens(index+1, len);
				}
			}
		}
	}
	
	private boolean isValidPosition(int k, int i){
		for (int j = 0; j < k; j++) {
			//same row or same diagonal
			if(config[j] == i || Math.abs(config[j]-i) == Math.abs(j-k)){
				return false;
			}
		}
		return true;
	}
	
	private void printBoard(){
		count++;
		for (int i = 0; i < config.length; i++) {
			System.out.print(columnMapping.get(config[i]) +""+ rowMapping.get(i));
			if(i!= config.length-1){
				System.out.print(", ");	
			}else{
				System.out.println("---------BOARD CONFIG END-------------- count: " + count);
				
			}
		}
	}
}
