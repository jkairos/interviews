package com.studies.peakFinder;

import static org.junit.Assert.*;

import org.junit.Test;

public class PeakFinderTest {

	@Test
	public void testPeakFinder1D() {
		PeakFinder pk = new PeakFinder();
		int a[]= {6,7,4,3,2,1,4,5};
		int expected = 7;
		int actual = pk.peakFinder1D(a);
		
		assertEquals(expected, actual);
	}

	@Test
	public void test2PeakFinder1D() {
		PeakFinder pk = new PeakFinder();
		int a[]= {5,10,20,15};
		int expected = 20;
		int actual = pk.peakFinder1D(a);
		
		assertEquals(expected, actual);
	}

	@Test
	public void test3PeakFinder1D() {
		PeakFinder pk = new PeakFinder();
		int a[]= {10,20,15,2,23,90,67};
		int expected = 20;
		int actual = pk.peakFinder1D(a);
		
		assertEquals(expected, actual);
	}

}
