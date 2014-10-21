package com.studies.heap;
import static org.junit.Assert.*;
import java.util.PriorityQueue;
import org.junit.Test;


public class HeapTest {
	
	@Test
	public void test(){
		int[] a = new int[]{2,11,8,10,12,20,25,28,30,35,56,78,90,101,202,4,6,7,8,9,9,0,3,4,5,6,7,8,9999};
		Heap heap = new Heap(5);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for (int i = 0; i < a.length; i++) {
			heap.add(a[i]);
			pq.add(a[i]);
		}
		
		Integer heapArray[] = heap.getArray();
		for (int number : heapArray) {
			System.out.println(number);
		}
	}
	
	@Test
	public void testHeapMit() {
		long start, end;
		start = System.currentTimeMillis();
		HeapMit heap  = new HeapMit();
		
		Integer a[]={4,1,3,2,16,9,10,14,8,7};
		Integer a1[]={16,14,10,8,7,9,3,2,4,1};
		
		heap.buildMaxHeap(a);
		assertArrayEquals(a1,a);
		end = System.currentTimeMillis();
		System.out.println("testBubbleSort: " + (end - start));
	}	

	@Test
	public void testHeapsort() {
		long start, end;
		start = System.currentTimeMillis();
		HeapMit heap  = new HeapMit();
		
		Integer a[]={4,1,3,2,16,9,10,14,8,7};
		Integer a1[]={1,2,3,4,7,8,9,10,14,16};
		
		heap.heapsort(a);
		assertArrayEquals(a1,a);
		end = System.currentTimeMillis();
		System.out.println("testBubbleSort: " + (end - start));
	}	
}
