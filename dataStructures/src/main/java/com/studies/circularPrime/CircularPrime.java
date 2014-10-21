package com.studies.circularPrime;

import java.util.ArrayList;
import java.util.List;

//O(n) -- Linear time
//A better solution would use Recursive calls to find out all the possible rotations(It is simpler than iterating)
public class CircularPrime {

	// A prime number it is a number, it is only divided by 1 and itself
	public int checkCircularPrime(int number) throws IllegalArgumentException {
		int countPrime = 0;

		if (number < 1 || number > 1000000) {
			throw new IllegalArgumentException(
					"Please inform a number greater or equal to 1 and equal or less than 1000000(1 <= N <= 1000000) ");
		}
		
		if (number == 2) {
			countPrime++;
		} else if (number % 2 != 0) {// ODD
			if (this.isNumberPrime(number)) {
				char[] array = String.valueOf(number).toCharArray(); // [1,3]
				if (array.length == 1) {
					countPrime++;
				} else if (array.length == 2) {// we only have two possible
												// combinations. The number
												// itself and the 2nd and 1st
												// position
					int prime2 = Integer.valueOf(array[1] + array[0]);

					if (this.isNumberPrime(prime2)) {
						countPrime++;
					}

				} else {// 197 -- --971, 719, 791
					// 2,3,1 -- 971
					// 2,1,3 -- 917
					// 3,1,2 -- 719
					// 3,2,1 -- 791
					// [1,9,7]

					List<Integer> rotations = this.getRotations(number);
					int countPrimeAux = 0;

					for (Integer n : rotations) {
						if (this.isNumberPrime(n)) {
							countPrimeAux++;
						}
					}

					if (rotations.size() == countPrimeAux) {
						countPrime++;
					}

				}
			}

		}
		
		return countPrime;

	}
	
	
	//197 n
	//791 -- 3,2,1
	//719 --   
	// O(n2) --> quadratic -- Needs improvement!
	private List<Integer> getRotations(int number) {
		List<Integer> rotations = new ArrayList<Integer>();
		StringBuilder numberStr = null;
		char[] array = String.valueOf(number).toCharArray();
		for (int i = 1; i < array.length; i++) {// 1,9,7, 0, length -1 2
			numberStr = new StringBuilder();
			numberStr.append(array[i]);
			for (int j = 0; j < array.length; j++) {// 2,1,3
				if (i != j) {
					numberStr.append(array[j]);
				}
			}
			//[2:20:30 PM] Martin Chikilian: len(s1) == len(s2)
			//if substr(s2, concat(s1, s1))
			//[2:21:17 PM] Martin Chikilian: '197197'
			if(numberStr.toString().indexOf(String.valueOf(number)+String.valueOf(number))!=-1){
				rotations.add(Integer.valueOf(numberStr.toString()));
			}
		}

		return rotations;
	}

	private boolean isNumberPrime(int number) {
		boolean result = false;
		int count = 0;
		int numberAux = number;

		while (numberAux > 0) {//197...1
			if (number % numberAux == 0) {
				count++;
			}

			if (count > 2) {
				break;
			}
			numberAux--;
		}
		
		if (count == 2) {
			result = true;
		}

		return result;
	}
	
	
	public static void main(String args[]){
		CircularPrime c = new CircularPrime();
		int number = 100;
		int counter = 0;
		
		for (int i = 2; i < number; i++) {
			counter+=c.checkCircularPrime(i);
		}
		
		System.out.println("Number of circular primes: " + counter);//13
	}

}