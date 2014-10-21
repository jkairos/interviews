package com.studies.heap;

import java.util.Arrays;
import java.util.Collections;

public class Heap {
	
	private int size;
	private Integer[] array;
	
	public Heap(){
		this(10);
	}
	
	public Heap(int initialCapacity){
		array = new Integer[initialCapacity];
	}
	
	public void add(int e){
		int i = size;
		
		if(i == array.length){
			Arrays.sort(array,Collections.reverseOrder());
			if(e < array[array.length-1]){
				return;
			}
			i = array.length-1;
		}else{
			size = i+1;
		}
		
		if(i == 0){
			array[0]=e;
		}else{
			shiftUp(i, e);
		}
	}
	
	private void shiftUp(int i, int e){
		while(i>0){
			int parent = (i-1)>>>1;
			int parentValue = array[parent];
			
			if(e < parentValue){
				break;
			}
			
			array[i] = parentValue;
			i = parent;
		}
		array[i] = e;
	}
	
	public void heapsort(){
	      int temp;     // Used during the swapping of two array locations
	      int end = size-1;
	      
	      while (end > 0){

	         // Swap the largest element (data[0]) with the final element of unsorted part  
	         temp = array[0];
	         array[0] = array[end];
	         array[end] = temp;
	         shiftUp(end,array[end]);
	         end--;
	      }
	}
	
	public Integer[] getArray(){
		return array;
	}
}
