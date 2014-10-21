package com.studies.recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class TelephoneNumberTest {

	@Test
	public void testPrintTelephoneNumber() {
		TelephoneNumber telephoneNumber = new TelephoneNumber();
		int phone[] = new int[]{8,6,6,2,6,6,9};
		telephoneNumber.printTelephoneNumber(phone);
	}

}
