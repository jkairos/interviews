package com.studies.binary;

import java.util.Arrays;
import java.util.Collections;

public class BinaryGap {

	public int count_div(int a, int b, int k) {
		b = b < 0 ? (b + 1) / k - 1 : b / k;
		a = a <= 0 ? a / k - 1 : (a - 1) / k;

		return b - a;
	}

	public int triangle(int[] array) {
		if (array.length < 3) {
			return 0;
		}

		// Tuned quicksort n*log(n)
		Arrays.sort(array);

		for (int i = 0; i + 2 < array.length; i++) {
			if (array[i] + array[i + 1] > array[i + 2]) {
				return 1;
			}
		}
		
		return 0;
	}

	public static void main(String args[]) {
		BinaryGap b = new BinaryGap();
		System.out.println(b.count_div(6, 11, 2));
		System.out.println(b.count_div(6, 11, 3));
		System.out.println(b.binary_gap(259));
	}

	public int binary_gap(int number) {
		long l = number;
		int zeros = Collections.max(Arrays.asList(Long.toBinaryString(l).split("1+"))).length();
		return zeros;
	}

	private String getBinary(Integer number) throws IllegalArgumentException {
		String result = null;

		if (number < 0) {
			throw new IllegalArgumentException("The number cannot be less than ZERO.");
		} else {
			result = this.getBin(number);
		}

		return result;
	}

	private String getBin(Integer number) {
		if (number <= 1) {
			return "1";
		} else {
			return getBin(number / 2) + Integer.toString(number % 2);
		}
	}

}
