package com.studies.searching;

public class BinarySearch {
	
	private BinarySearch(){}
	
	/*
	 * SEARCH A SORTED ARRAY FOR A[i] = i
	 * 
	 * Solution 1.4: Since the array contains distinct integers and is sorted,
	 * for any i > 0, A[i] > A[i- 1] + 1. Therefore B[i] = A[i] - i is also
	 * nondecreasing. It follows that we can do a binary search for a in B to
	 * find an index such that A[i] = i. (We do not need to actually create B, we
	 * can simply use A[i] - i wherever B[i] is referenced.)
	 * 
	 * This can be done in O(logN) time and O(1) space by using a slightly modified binary search.
	 * Consider a new array Y such that Y[i] = X[i] - i
	 * 
	 * Array X : -3 -1   0  3  5  7
	 * index   :  0  1   2  3  4  5
	 * Array Y : -3 -2  -2  0  1  2
	 * 
	 * Since the elements in X are in increasing order, the 
	 * elements in the new array Y will be in non-decreasing order. 
	 * So a binary search for 0 in Y will give the answer.
	 */
	public static int findIndex(int[] array){
		return findIndex(array,0,0,array.length -1);
	}
	
	private static int findIndex(int[] array, int number, int low, int high){ 
		if (low > high || high < low){
			return -1;
		}
		
		int mid = (low+high) >>> 1;//or low + (high-low)/2
		
		if(array[mid]-mid == number){
			return mid;
		}else if (array[mid]-mid > number){
			return findIndex(array, number, low, mid-1);
		}else{
			return findIndex(array, number, mid+1, high);
		}
	}
	
	/*
	 * You are given an array of integers, sorted, but rotated. 
	 * Find an better than O(n) algorithm to find an element in an array
	 * 
	 * This can be done in O(logN) using a slightly modified binary search.
	 * The interesting property of a sorted + rotated array is that when you divide it into two halves, 
	 * at least one of the two halves will always be sorted.
	 * 
	 * Let input array arr = [4,5,6,7,8,9,1,2,3]
	 * number of elements  = 9
	 * mid index = (0+8)/2 = 4
	 * [4,5,6,7,8,9,1,2,3]
	 *          ^
	 *  left   mid  right
	 *  
	 *  as seem right sub-array is not sorted while left sub-array is sorted.
	 *  
	 *  If mid happens to be the point of rotation them both left and right sub-arrays will be sorted.
	 *  [6,7,8,9,1,2,3,4,5]
     *           ^
     *  But in any case one half(sub-array) must be sorted.
     *  We can easily know which half is sorted by comparing start and end element of each half.
     *  Once we find which half is sorted we can see if the key is present in that half - simple comparison with the extremes.
     *  If the key is present in that half we recursively call the function on that half 
     *  else we recursively call our search on the other half. 
     *  We are discarding one half of the array in each call which makes this algorithm O(logN).
	 */
	public static int findIndexOfSortedRotatedArray(int [] array, int key){
		return findIndexOfSortedRotatedArray(array, key, 0, array.length-1);
	}
	
	private static int findIndexOfSortedRotatedArray(int [] array, int key, int low, int high){
		if(low > high || high < low){
			return -1;
		}
		
		int mid = low + (high-low)/2;
		
		if(array[mid] == key){
			return mid;
		}else if(array[low] <= array[mid]){//left sub-array is sorted
			if(key>=array[low] && key <= array[mid]){//key in the left subtree
				return findIndexOfSortedRotatedArray(array, key, low, mid-1);
			}else{//Go right
				return findIndexOfSortedRotatedArray(array, key, mid+1,high);
			}
		}else{//right subtree is sorted
			if(key>=array[mid] && key <= array[high]){//key in the right subtree
				return findIndexOfSortedRotatedArray(array, key, mid+1,high);
			}else{//Go Left
				return findIndexOfSortedRotatedArray(array, key, low, mid-1);
			}
		}
	}
}
