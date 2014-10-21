 package com.studies.dataTypes;

public class StringStudy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s4 = new String("restful");
		String s5 = new String("restful"); 
		String s6 = new String("peaceful"); 
		String s7 = s4; 
		String s8 = "restful";
		String s9 = "restful";
		
		System.out.println(s4.equals(s5)); // the output is "true"
		System.out.println(s4.equals(s6)); // the output is "false"
		System.out.println(s4 == s5); // the output is "false"
		System.out.println(s4 == s7); // the output is "true"
		System.out.println(s4 == s8); // the output is "false"
		System.out.println(s8 == s9); // the output is "true"

	}

}
