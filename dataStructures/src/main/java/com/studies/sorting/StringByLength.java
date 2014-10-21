package com.studies.sorting;

import java.util.Comparator;

public class StringByLength implements Comparator<String> {

	/**
	 * Compares two specified String objects lexicographically if they have the
	 * same length, and otherwise returns the difference in their lengths.
	 * 
	 * @param s1
	 *            - one of the specified String objects.
	 * @param s2
	 *            - the other specified String object.
	 * 
	 * @return s1.compareTo (s2) if s1 and s2 have the same length; otherwise,
	 *         return s1.length() - s2.length().
	 * 
	 */
	public int compare(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
		if (len1 == len2)
			return s1.compareTo(s2);
		return len1 - len2;
	} // method compare
}
