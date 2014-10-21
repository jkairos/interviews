package com.studies.backtracking;

/**
 * For this backtracking approach we will be using the Skiena's backtracking algorithm, as follows:
 * 
 * 
 * bool finished = FALSE; // found all solutions yet? 
 * backtrack(int a[], int k, data input){
 * 		int c[MAXCANDIDATES]; // candidates for next position
 * 		int ncandidates; // next position candidate count
 * 		int i; // counter
 * 		if (is_a_solution(a,k,input))
 * 			process_solution(a,k,input);
 * 		else {
 * 			k = k+1;
 * 			construct_candidates(a,k,input,c,&ncandidates);
 * 			for (i=0; i<ncandidates; i++) {
 * 				a[k] = c[i];
 * 				make_move(a,k,input);
 * 				backtrack(a,k,input);
 * 				unmake_move(a,k,input);
 * 				if (finished) return; // terminate early
 * 			}
 * 		}
 * }
 *
 */
public class Permutation {
	
	
	public void perm(String str){
		char[] array = str.toCharArray();
		this.backtrack(new int[array.length], 0, array);
	}
	
	private void backtrack(int []a, int k, char[] input){
		if(isASolution(a, k, input)){
			processSolution(a, k, input);
		}else{
			int[] candidates = constructCandidates(a, k, input);
			
			for(int i=0; i < candidates.length; i++){
				a[k] = candidates[i];
				backtrack(a, k+1, input);
			}
		}
	}
	
	private boolean isASolution(int[] a, int k, char input[]){
		return k == input.length;
	}
	
	private int[] constructCandidates(int[] a, int k, char input[]){
		boolean inPerm[] = new boolean[input.length];
		int maxCandidates = input.length - k;
		
		for (int i=0; i<k; i++){
			inPerm[a[i]] = true;
		}

		int ncandidates = 0;
		int candidates[] = new int[maxCandidates];
		
		for (int i=0; i<input.length; i++){
			if (!inPerm[i]) {
				candidates[ncandidates] = i;
				ncandidates++;
			}
			
		}
		
		return candidates;
	}
	
	private void processSolution(int[] a, int k, char input[]){
		System.out.print(" ");
		for (int i = 0; i < k ;i++){
			System.out.print(input[a[i]]);
		}
		System.out.print(" ");
	}
}
