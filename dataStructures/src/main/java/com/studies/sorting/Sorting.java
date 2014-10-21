package com.studies.sorting;

import java.util.Comparator;

public final class Sorting {

	private Sorting() {
	}
	
	//O(n2)
	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0 && array[j] < array[j-1]; j--) {
				swap(array, j, j - 1);
			}
		}
	}
	
	//O(n2)
	public static void selectionSort(int[] array) {
		int min = 0;
		for (int i = 0; i < array.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			swap(array, i, min);
		}
	}
	
	//O(n2)
	public static void bubbleSort(int[] array) {
		int len = array.length;
		
		for(int i = len-1; i > 0 ; i--){
			for(int j=0; j< len-1; j++){
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		
	} // method bubbleSort

	public static <T> void selectionSortComparator(T[] array, Comparator<T> comp) {
		int pos = 0;

		for (int i = 0; i < array.length - 1; i++) {
			pos = i;

			for (int j = i + 1; j < array.length; j++) {
				if (comp.compare(array[j], array[pos])  < 0) {
					pos = j;
				}
			}

			swap(array, i, pos);
		}
	}

	private static void swap(int[] array, int indexOfElementToSwap, int indexOfOtherElementToSwap) {
		int temp = array[indexOfElementToSwap];
		array[indexOfElementToSwap] = array[indexOfOtherElementToSwap];
		array[indexOfOtherElementToSwap] = temp;
	}

	private static <T> void swap(T[] x, int a, int b) {
		T temp = x[a];
		x[a] = x[b];
		x[b] = temp;
	} // swap
}
