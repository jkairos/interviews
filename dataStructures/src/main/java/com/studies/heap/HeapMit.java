package com.studies.heap;

public class HeapMit {
	private int heapsize;
	/**
	 * Heap-Sort
	 * 	Sorting Strategy:
	 * 		1. Build Max Heap from unordered array;
	 * 		2. Find maximum element A[1];
	 * 		3. Swap elements A[n] and A[1]:now max element is at the end of the array!
	 * 		4. Discard node n from heap (by decrementing heap-size variable)
	 * 		5. New root may violate max heap property, but its children are max heaps. Run max_heapify to fix this.
	 * 		6. Go to Step 2 unless heap is empty. 
	 * @param a
	 */
	public void heapsort(Integer []a){
		this.buildMaxHeap(a);
		
		for(int n=a.length-1;n >=0; n--){
			Integer temp = a[0];
			a[0]=a[n];
			a[n]=temp;
			heapsize--;
			this.maxHeapify(a, 0,heapsize);
		}
	}
	
	public void buildMaxHeap(Integer []a){
		heapsize=a.length;
		for(int i=((a.length-1)/2);i>=0;i--){
			maxHeapify(a,i,heapsize);
		}
	}
	
	private void maxHeapify(Integer a[], int i, int len){
		Integer largest = 0;

		Integer l = left(len,i);
		Integer r = right(len,i);
		
		if(l!=null && l < len && a[l] > a[i]){
			largest=l;
		}else if(r!=null){
			largest = i;
		}

		if(r!=null && r < len && a[r] > a[largest]){
			largest=r;
		}
		
		if(!largest.equals(i)){
			Integer temp = a[i];
			a[i]=a[largest];
			a[largest]=temp;
			maxHeapify(a,largest,len);
		}
	}
	
	private Integer left(int len, int i){
		Integer index = null;
		index = 2*(i)+1;
		return index >= len ? null : index;
	}

	private Integer right(int len, int i){
		Integer index = null;
		index = 2*(i)+2;
		return index >= len ? null : index;
	}
}
