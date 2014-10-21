package com.studies.backtracking;

public class SumOfSubsets {
	
	boolean finished;
	
	public void sumOfSubsets(int []input, int desiredSum){
		this.backtrack(new boolean[input.length], 0, input, desiredSum);
	}
	
	private void backtrack(boolean partialSolution[], int k, int []input, int desiredSum){
		if(this.isASolution(partialSolution, input,desiredSum)){
			this.processSolution(partialSolution, input);
			finished = true;
		}else{
			boolean[] candidates = this.constructCandidates(partialSolution, k, input);
			
			for (int i = 0 ;i < candidates.length ;i ++){
				partialSolution[k] = candidates[i];

				if(k+1<input.length){
					this.backtrack(partialSolution, k+1, input, desiredSum);
				}
				if(finished){
					return;
				}
			}
		}
	}

	
	private boolean[] constructCandidates(boolean partialSolution[], int k, int []input){
		boolean ret[] = {true,false};
		return ret;
	}
	
	private boolean isASolution(boolean[] partialSolution, int[] input, int desiredSum){
		boolean result = false;
		
		if(this.sum(partialSolution, input) == desiredSum){
			result = true;
		}
		
		return result;
	}
	
	private void processSolution(boolean[] partialSolution, int[] input){
		System.out.print("[");
		for (int i=0; i < input.length; i++) {
			if(partialSolution[i]){
				System.out.print(" ");
				System.out.print(input[i]);
			}
		}
		System.out.print("] ");
		
	}
	
	private int sum(boolean[] partialSolution, int[] input){
		int sum = 0;
		
		for(int i =0; i < input.length ; i++){
			if(partialSolution[i]){
				sum+=input[i];
			}
		}
		
		return sum;
	}
}
