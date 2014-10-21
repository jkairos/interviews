package com.studies.sorting;

import static org.junit.Assert.*;

import org.junit.Test;
import com.studies.sorting.Sorting;


public class SortingTest {
	
	private int[] unsorted = {5,9,2,7,1};
	
	private int[] sorted = {1,2,5,7,9};

	private int[] actual = {59, 46, 32, 80, 46, 55, 50, 43, 44, 81,
			12, 95, 17, 80, 75, 33, 40, 61, 16, 87};
	
	private int[] expected = {12, 16, 17, 32, 33, 40, 43, 44, 46, 46,
			50, 55, 59, 61, 75, 80, 80, 81, 87, 95};
	
	@Test
	public void testInsertionSort() {
		long start, end;
		start = System.currentTimeMillis();
		Sorting.insertionSort(actual);
		assertArrayEquals(expected,actual);
		end = System.currentTimeMillis();
		System.out.println("testInsertionSort: " + (end - start));
	}

	@Test
	public void testSelectionSort() {
		long start, end;
		start = System.currentTimeMillis();
		Sorting.selectionSort(actual);
		assertArrayEquals(expected,actual);
		end = System.currentTimeMillis();
		System.out.println("testSelectionSort: " + (end - start));
	}

	@Test
	public void testBubbleSort() {
		long start, end;
		start = System.currentTimeMillis();
		Sorting.bubbleSort(unsorted);
		assertArrayEquals(sorted,unsorted);
		end = System.currentTimeMillis();
		System.out.println("testBubbleSort: " + (end - start));
	}

	@Test
	public void testSelectionSortComparator() {
		long start, end;
		String[ ] words = {"Jayden", "Jack", "Rowan", "Brooke"};
		String[ ] expectedWords = {"Jack", "Rowan", "Brooke", "Jayden"};
		
		start = System.currentTimeMillis();
		Sorting.selectionSortComparator(words, new StringByLength());
		assertArrayEquals(expectedWords,words);
		end = System.currentTimeMillis();
		System.out.println("testSelectionSortComparator: " + (end - start));
	}

}
