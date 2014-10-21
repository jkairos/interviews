package com.studies.peakFinder;

public class PeakFinder {
	
	public int peakFinder1D(int[] a){
		return peakFinder1D(a, 0, a.length-1);
	}
	
	private int peakFinder1D(int[] a, int start, int end){
		if (start > end || end < start){
			return -1;
		}

		int i= (end+start)>>>1;
		
		if(i==0){
			if(a[i]>a[i+1]){
				return a[i];
			}else{
				return -1;
			}
		}else if(i==a.length-1){
			if(a[i]>a[i-1]){
				return a[i];
			}else{
				return -1;
			}
			
		}else if(a[i]>a[i-1] && a[i]>a[i+1]){
			return a[i];
		}else{
			if(a[i]<a[i-1]){//go left
				return peakFinder1D(a,start,i-1);
			}else{
				return peakFinder1D(a,i+1,end);
			}
		}
	}
}
