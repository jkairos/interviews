package com.studies.string;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testFirstNonRepeatedStringHash() {
		long start, end;
		start = System.currentTimeMillis();
		assertEquals(Character.valueOf('z'),StringUtils.getFirstNonRepeatedStringHash("abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvx" +
				"abcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxabcdefghijlkmnoprrstuvxz"));
		end = System.currentTimeMillis();
		System.out.println("testFirstNonRepeatedStringIteratively: " + (end - start));
	}

	@Test
	public void testFirstNonRepeatedStringIteratively() {
		long start, end;
		start = System.currentTimeMillis();
		assertEquals(Character.valueOf('z'),StringUtils.getFirstNonRepeatedStringIteratively("aaaaaaaaaaaaaaaaaaaaaazaaaaaaa"));
		end = System.currentTimeMillis();
		System.out.println("testFirstNonRepeatedStringIteratively: " + (end - start));
	}

	@Test
	public void testRemoveChars() {
		long start, end;
		start = System.currentTimeMillis();
		assertEquals("totl",StringUtils.removeChars("total", "a"));
		end = System.currentTimeMillis();
		System.out.println("testRemoveChars: " + (end - start));
	}

	@Test
	public void testRemoveCharsStringBuilder() {
		long start, end;
		start = System.currentTimeMillis();
		assertEquals("Haing justified and analyzed your solution, you’re ready to code it. You can write this function in " +
				"Jaa.(The C# implementation would be nearly identical.) Because this problem inoles " +
				"string manipulationand the String class is immutable, you need to either conert the string to a char array " +
				"or use aStringBuilder for your manipulations. Array access has more compact syntax and typically less oerheadthan method inocations " +
				"on a StringBuilder, so using an array is probably the better choice.",StringUtils.removeCharsStringBuilder("Having justified and analyzed your solution, you’re ready to code it. You can write this function in Java." +
						"(The C# implementation would be nearly identical.) Because this problem inoles string manipulation" +
						"and the String class is immutable, you need to either conert the string to a char array or use a" +
						"StringBuilder for your manipulations. Array access has more compact syntax and typically less overhead" +
						"than method invocations on a StringBuilder, so using an array is probably the better choice.", "v"));
		end = System.currentTimeMillis();
		System.out.println("testRemoveCharsStringBuilder: " + (end - start));
	}
	
	@Test
	public void testRemoveChars2(){
		String str = "battle";
		String remove = "aeiou";
		assertEquals("bttl", StringUtils.removeChars2(str, remove));
	}
	
	@Test
	public void testReverseString() {
		assertEquals("try. no is there not, do or Do", StringUtils.reverseString("Do or do not, there is no try."));
	}

	@Test
	public void testReverseString2() {
		assertEquals("I will ace the interviews.", StringUtils.reverseString2("I will ace the interviews."));
	}
	
	@Test
	public void testPermute(){
		String str ="abcd";
		StringUtils.permute(str);
		
	}

	@Test
	public void testCombine(){
		String str ="abc";
		StringUtils.combine(str);
		
	}

	@Test
	public void testPermute2(){
		String str ="abc";
		StringUtils.permute2(str);
		
	}
	
	@Test
	public void testIsRotation(){
		assertEquals(true, StringUtils.isRotation("amazon", "mazona"));
	}

	@Test
	public void testIsRotation2(){
		assertEquals(false, StringUtils.isRotation("amazon", "mazon"));
	}
	
	@Test
	public void testIsRotation3(){
		assertEquals(false, StringUtils.isRotation("amazon", "mazonas"));
	}

	@Test
	public void testReverseStringXOR(){
		String str="Hello World";
		System.out.println(StringUtils.reverseStringXOR(str));
	}
}
