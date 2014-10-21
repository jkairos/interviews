package com.studies.searching;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void testFindIndex() {
		int[] array = new int[]{-3,-1,0,2,3,5,7};
		assertEquals(5, BinarySearch.findIndex(array));
	}

	@Test
	public void testFindIndex2() {
		int[] array = new int[]{-3,-1,0,2,3,6,7};
		assertEquals(-1, BinarySearch.findIndex(array));
	}
	
	@Test
	public void testFindIndex3() {
		int[] array = new int[]{-3,-1,0,3,5,6,7};
		assertEquals(3, BinarySearch.findIndex(array));
	}
	
	@Test
	public void testFindIndexOfSortedRotatedArray(){
		int[] array = new int[]{4,5,6,7,8,9,1,2,3};
		assertEquals(5, BinarySearch.findIndexOfSortedRotatedArray(array,9));
	}

	@Test
	public void testFindIndexOfSortedRotatedArray2(){
		int[] array = new int[]{4,5,6,7,8,9,1,2,3};
		assertEquals(-1, BinarySearch.findIndexOfSortedRotatedArray(array,23));
	}

	@Test
	public void testFindIndexOfSortedRotatedArray3(){
		int[] array = new int[]{4,5,1,2,3};
		assertEquals(0, BinarySearch.findIndexOfSortedRotatedArray(array,4));
	}
}
