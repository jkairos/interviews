package com.studies.dp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	//Run Time Analysis: O(c^ n) --Exponential
	public static int fibRecursive(int n){
		if(n == 1 || n ==2){
			return 1;
		}else{
			return fibRecursive(n-1)+fibRecursive(n-2);
		}
	}

	//Run Time Analysis: O(n) , Space Complexity: O(1)
	public static int fibMemoization(int n){
		return fibMemoization(n, new HashMap<Integer,Integer>());
	}
	
	//Run Time Analysis: O(n) , Space Complexity: O(1)
	private static int fibMemoization(int n, Map<Integer,Integer> map){
		
		if(map.containsKey(n)){
			return map.get(n);
		}
		if(n <= 2){
			map.put(1,1);
			return map.get(1);
		}else{
			if(!map.containsKey(n)){
				map.put(n, fibMemoization(n-1,map)+fibMemoization(n-2,map));
			}
			return map.get(n);
		}
	}
	
	//Run Time Analysis: O(n)
	public static int fibDp(int n){
		if (n ==0){
			return 0;
		}else{
			int previousFib=0;
			int currentFib=1;
			int newFib=0;
			
			for(int i= 2; i <=n; i++){
				newFib = previousFib + currentFib;
				previousFib = currentFib;
				currentFib = newFib;
			}
			
			return currentFib;
		}
	}
	
	public static void main(String args[]){
		
		System.out.println("DP Start: " +new Date());
		System.out.println(fibDp(60));
		System.out.println("DP End: " +new Date());

		System.out.println("Recursive + Memoization Start: " +new Date());
		System.out.println(fibMemoization(60));
		System.out.println("Recursive + Memoization End: " +new Date());

		System.out.println("Recursive Start: " +new Date());
		System.out.println(fibRecursive(60));
		System.out.println("Recursive End: " +new Date());
		
	}
}
