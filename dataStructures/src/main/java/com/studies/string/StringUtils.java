package com.studies.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public final class StringUtils {

	private StringUtils() {
	}

	public static Character getFirstNonRepeatedStringHash(String str) {
		Character ch = null;

		char[] charArray = str.toCharArray();
		Map<Character, Integer> mapCharsCount = new HashMap<Character, Integer>();

		// scan charArray, building hash table
		for (char c : charArray) {
			if (mapCharsCount.containsKey(c)) {
				if (mapCharsCount.get(c) == 1) {
					mapCharsCount.put(c, mapCharsCount.get(c) + 1);
				}
			} else {
				mapCharsCount.put(c, 1);
			}
		}

		// Search hash table in order of str
		for (char c : charArray) {
			if (mapCharsCount.get(c) == 1) {
				ch = c;
				break;
			}
		}

		return ch;
	}

	public static Character getFirstNonRepeatedStringIteratively(String str) {
		Character ch = null;
		char[] charArray = str.toCharArray();
		boolean isRepeated = false;

		for (int i = 0; i < charArray.length; i++) {
			isRepeated = false;
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] == charArray[j]) {
					isRepeated = true;
					break;
				}
			}
			if (!isRepeated) {
				ch = charArray[i];
				break;
			}
		}

		return ch;
	}

	public static String removeChars(String str, String remove) {
		char[] s = str.toCharArray();
		char[] r = remove.toCharArray();
		int src, dst = 0;
		// flags automatically initialized to false, size of 128 assumes ASCII
		boolean[] flags = new boolean[128];
		// Set flags for characters to be removed
		for (src = 0; src < r.length; ++src) {
			flags[r[src]] = true;
		}
		// Now loop through all the characters,
		// copying only if they aren’t flagged
		for (src = 0; src < s.length; ++src) {
			if (!flags[s[src]]) {
				s[dst++] = s[src];
			}
		}
		return new String(s, 0, dst);
	}

	public static String removeCharsStringBuilder(String str, String remove) {
		String strReturn = null;

		StringBuilder sb = new StringBuilder();
		Set<Character> setAux = new HashSet<Character>();

		char[] removeChar = remove.toCharArray();

		// O(n)
		for (char c : removeChar) {
			setAux.add(c);
		}

		char[] strChar = str.toCharArray();

		// O(n)
		for (char c : strChar) {
			if (!setAux.contains(c)) {
				sb.append(c);
			}
		}

		strReturn = sb.toString();
		return strReturn;
	}

	public static String removeChars2(String str, String remove) {
		char[] array = str.toCharArray();
		StringBuilder result = new StringBuilder();

		// O(n)
		for (char c : array) {
			if (!remove.contains(String.valueOf(c))) {
				result.append(c);
			}
		}

		return result.toString();
	}

	public static String reverseString(String str) {
		StringBuilder reversedStr = new StringBuilder();

		String[] strSplitted = str.split(" ");

		Stack<String> stack = new Stack<String>();

		for (String string : strSplitted) {
			stack.push(string);
		}

		while (!stack.isEmpty()) {
			reversedStr.append(stack.pop());
			reversedStr.append(" ");
		}

		// ro remove the last space
		reversedStr.setLength(reversedStr.length() - 1);

		return reversedStr.toString();
	}

	public static String reverseString2(String str) {
		StringBuilder reversedStr = new StringBuilder();

		String[] strSplitted = str.split(" ");

		for (int i = 0; i < strSplitted.length; i++) {
			reversedStr.append(strSplitted[i]);
			reversedStr.append(" ");
		}

		// remove the last space
		reversedStr.setLength(reversedStr.length() - 1);

		return reversedStr.toString();
	}

	public static void permute(String str) {
		StringBuilder strBuf = new StringBuilder(str);
		doPerm(strBuf, str.length());
	}

	private static void doPerm(StringBuilder str, int index) {
		if (index == 0)
			System.out.println(str);
		else { // recursively solve this by placing all other chars at current
				// first pos
			doPerm(str, index - 1);
			int currPos = str.length() - index;
			for (int i = currPos + 1; i < str.length(); i++) {// start swapping all other chars with current first char
				swap(str, currPos, i);
				doPerm(str, index - 1);
				swap(str, i, currPos);// restore back my string buffer
			}
		}
	}

	private static void swap(StringBuilder str, int pos1, int pos2) {
		char t1 = str.charAt(pos1);
		str.setCharAt(pos1, str.charAt(pos2));
		str.setCharAt(pos2, t1);
	}

	public static void combine(String str) {
		StringBuilder out = new StringBuilder();
		combine(str, out, 0);
	}

	private static void combine(String str, StringBuilder out, int start) {
		for (int i = start; i < str.length(); i++) {
			out.append(str.charAt(i));
			System.out.println(out);
			if (i < str.length())
				combine(str, out, i + 1);
			out.setLength(out.length() - 1);
		}
	}
	
	public static void permute2(String str){
		char[] ch = str.toCharArray();
		doPermute(ch, 0, ch.length-1);
	}
	
	private static void doPermute(char[] array, int k, int n){
		if(k == n){
			printPermutation(array);
		}else{
			for (int i = k; i < array.length; i++) {
				swap(array,k,i);
				doPermute(array, k+1, n);
				swap(array,k,i);
			}
		}
	}
	
	private static char[] swap(char[] array, int k, int i){
		char t = array[k];
		array[k] = array[i];
		array[i] = t;
		return array;
	}
	
	private static void printPermutation(char[] array){
		System.out.print("[ ");
		
		for(int i=0; i <  array.length ; i++){
			if(i != array.length - 1){
				System.out.print(array[i] + ", ");
			}else{
				System.out.print(array[i] + " ");
			}
		}
		
		System.out.print("] ");
		System.out.println("-----------------------------------");
		
	}
	
	public static boolean isRotation(String s1, String s2){
		return s1.length() == s2.length() && (s1+s1).contains(s2);
	}
	
	public static String reverseStringXOR(String str){
		return reverseString(str, 0 , str.length()-1);				
	}
	
	private static String reverseString(String str, int start, int end){
		char c[] = str.toCharArray();
	    while (start < end){
	        /*This is how you can swap two variables without
	        using a temporary one. Look at how XORING a variable
	        with itself results in 0.*/
	        c[start] ^= c[end];
	        c[end]  ^= c[start];
	        c[start] ^= c[end];
	        ++start;
	        --end;
	    }
	    
	    return String.valueOf(c);
	}
	
}
