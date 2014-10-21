package com.studies.recursion;

import java.util.HashMap;
import java.util.Map;

public class TelephoneNumber {
	private static Map<Integer, Character[]> telephoneKeyMap;
	private static final int PHONE_NUMBER_LENGTH = 7;
	private char[] result = new char[PHONE_NUMBER_LENGTH]; 
	private int count;
	
	static {
		telephoneKeyMap = new HashMap<Integer, Character[]>();
		telephoneKeyMap.put(2, new Character[] { 'A', 'B', 'C' });
		telephoneKeyMap.put(3, new Character[] { 'D', 'E', 'F' });
		telephoneKeyMap.put(4, new Character[] { 'G', 'H', 'I' });
		telephoneKeyMap.put(5, new Character[] { 'J', 'K', 'L' });
		telephoneKeyMap.put(6, new Character[] { 'M', 'N', 'O' });
		telephoneKeyMap.put(7, new Character[] { 'P', 'R', 'S' });
		telephoneKeyMap.put(8, new Character[] { 'T', 'U', 'V' });
		telephoneKeyMap.put(9, new Character[] { 'W', 'X', 'Y','Z' });
	}

	public void printTelephoneNumber(int[] telephone) {
		this.printTelephoneNumber(telephone, 0, new StringBuilder());
	}

	private void printTelephoneNumber(int[] phoneNum, int curDigit, StringBuilder str) {
		if (curDigit == PHONE_NUMBER_LENGTH) {
			count++;
			System.out.println(str + "---count: " + count);
			return;
		}
		
		Character[] mapping = telephoneKeyMap.get(phoneNum[curDigit]);
		
		for (int i = 0; i < mapping.length; ++i) {
			str.append(getCharKey(phoneNum[curDigit], i));
			result[curDigit] = getCharKey(phoneNum[curDigit], i); 
			printTelephoneNumber(phoneNum, curDigit + 1, str);
			str.setLength(str.length()-1);
			if (phoneNum[curDigit] == 0 || phoneNum[curDigit] == 1)
				return;
		}

	}

	private char getCharKey(int key, int place) {
		return telephoneKeyMap.get(key)[place];
	}
}
