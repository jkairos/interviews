package com.studies.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public final class ArrayUtils {

	private ArrayUtils(){}
	
	/**
	 * Lets say you have array A[0]=1 A[1]=-1 ....A[n]=x
	 * 
	 * Then what would be the smartest way to find out the number of times 
	 * when A[i]+A[j] is even where i < j 
	 * So if we have {1,2,3,4,5} we have 1+3 1+5 2+4 3+5 = 4 pairs which are even
	 * 
	 * The sum of two integers is even if and only if they are either both even or both odd. 
	 * You can simply go through the array and count evens and odds. 
	 * The number of possibilities to combine k numbers from a set of size N is 
	 * N! / ((N - k)! · k!). You just need to put the number of evens/odds as N and 2 as k. 
	 * For this, the above simplifies to (N · (N - 1)) / 2. 
	 * All the condition i < j does is to specify that each combination counts only once.
	 */
	public static int getNumSumsOfTwoEven(int[] a) {
		int countEven = 0;
		int countOdd = 0;
		int evenSum = 0;
		
		for (int i : a) {
			if(i%2 == 0){
				countEven++;
			}else{
				countOdd++;
			}
		}
		
		evenSum = (countEven*(countEven-1))/2 + (countOdd*(countOdd-1))/2;
		
		return evenSum;
	}
	
	public static int equi(int[] array) {
		long sum = 0;
		long leftSum = 0;
		
		//Find sum of the whole array
		for (int i : array) {
			sum+=i;
		}
		
		for (int i = 0; i < array.length; i++){
			sum -= array[i];
			if(leftSum == sum){
				return i;
			}else{
				leftSum += array[i];
			}
		}
		
		//If no Equilibrium Index found return -1
		return -1;
	}
	
	public static int firstCoveringPrefix(int[] array){
		Map<Integer,Integer> indexes = new HashMap<Integer,Integer>();
	    
		// start from the back
	    for(int i = array.length - 1; i >= 0; i--) {
	        indexes.put(array[i],i);
	    }
	    // now find the highest value in the map
	    int highestIndex = 0;
	    for(Integer i : indexes.values()) {
	        if(highestIndex < i.intValue()) highestIndex = i.intValue();
	    }
	    return highestIndex;		
		
	}
	
	public static int number_of_disc_intersections (int[] array) {
		int sum=0;

		int[] start = new int[array.length];
	    int[] end = new int[array.length];

	    for (int i=0;i<array.length;i++){
	        if (i<array[i]) {
	        	start[0]++;
	        }else{
	        	start[i-array[i]]++;
	        }
	        if (i+array[i]>=array.length){
	        	end[array.length-1]++;
	        }else{
	        	end[i+array[i]]++;
	        }
	    }
	    
	    int active=0;
	    for (int i=0;i<array.length;i++){
	        sum+=active*start[i]+(start[i]*(start[i]-1))/2;
	        if (sum>10000000) return -1;
	        active+=start[i]-end[i];
	    }
	    return sum;
	}
}
