package com.studies.recursion;

public class DecimalToBinary {
	public String getBinary(Integer number) throws IllegalArgumentException{
		String result = null;
		
		if(number < 0){
			throw new IllegalArgumentException("The number cannot be less than ZERO.");
		}else{
			result = this.getBin(number);
		}
		
		return result;
	}
	
	private String getBin(Integer number){
		if(number <=1 ){
			return "1";
		}else{
			return getBin(number/2) + Integer.toString(number%2);
		}
	}
}
