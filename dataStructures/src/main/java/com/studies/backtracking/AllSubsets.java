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
public class AllSubsets<E> {
	
	public void subset(E []input){
		this.backtrack(new boolean[input.length], 0, input);
	}
	
	private void backtrack(boolean partialSolution[], int k, E []input){
		if(this.isASolution(partialSolution, k, input)){
			this.processSolution(partialSolution, k, input);
		}else{
			boolean[] candidates = this.constructCandidates(partialSolution, k, input);
			
			for (int i = 0 ;i < candidates.length ;i ++){
				partialSolution[k] = candidates[i];
				this.backtrack(partialSolution, k+1, input);
			}
		}
	}
	
	private boolean isASolution(boolean partialSolution[], int k, E []input){
		return k==input.length;
	}
	
	private boolean[] constructCandidates(boolean partialSolution[], int k, E []input){
		boolean ret[] = {true,false};
		return ret;
	}
	
	private void processSolution(boolean partialSolution[], int k, E []input){
		System.out.print("{");
		for (int i=0; i < input.length; i++) {
			if(partialSolution[i]){
				System.out.print("");
				System.out.print(input[i]);
			}
		}
		System.out.print("} ");
		
	}
}
