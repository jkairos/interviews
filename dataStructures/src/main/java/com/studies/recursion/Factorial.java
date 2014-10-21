package com.studies.recursion;

public class Factorial {
	
	public long getFactorial(Integer number) throws IllegalArgumentException{
		if(number < 0){
			throw new IllegalArgumentException("The number cannot be less than ZERO");
		}else{
			long result = 0;
			result = this.getFact(number);
			return result;
		}
	}
	
	private long getFact(Integer number){
		if(number <= 1){
			return 1;
		}else{
			return number * getFact(number -1);
		}
	}
}
