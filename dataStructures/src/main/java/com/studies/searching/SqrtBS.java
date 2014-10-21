package com.studies.searching;

public class SqrtBS {
	private SqrtBS(){}
	
	public static int sqrt(int number){
		return sqrtIteratively(number);
	}

	public static int sqrtRecursively(int number){
		return sqrtRecursively(number,0,65536);
	}
	
	private static int sqrtIteratively(int number){
		int low = 0;
		int high = 65536;
		int mid = 0;
		int midSqrt = 0;
		
		while(low+1<high){
			mid = low + (high-low)/2;
			midSqrt = mid * mid;
			
			if(number == midSqrt){
				return mid;
			}else if(number > midSqrt){
				low = mid;
			}else{
				high = mid;
			}
		}
		
		
		return low;
	}
	
	private static int sqrtRecursively(int number, int low, int high){
		int mid = low + high >>> 1;
		int midSqrt = mid*mid;
		
		if(low+1>=high){
			return low;
		}else{
			if(midSqrt == number){
				return mid;
			}else if(number > midSqrt){
				return sqrtRecursively(number,mid,high);
			}else{
				return sqrtRecursively(number,low,mid);
			}
		}
		
	}
}
