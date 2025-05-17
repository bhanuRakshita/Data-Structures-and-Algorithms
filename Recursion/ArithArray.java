package Recursion;

public class ArithArray {
    /*
	 * Return an array storing the first n numbers in an arithmetic sequence,
	 * with initial term 'start' and common difference 'diff'.  
	 * You can assume that n is non-negative (larger than or equal to 0).
	 * e.g., arithmeticArray(2, 3, 5) returns an array {2, 5, 8, 11, 14}.
	 * 
	 * Parameters:
	 * `start`: the first term in an arithmetic sequence
	 * `diff`: the common difference between terms in an arithmetic sequence
	 * `n`: the first n numbers in an arithmetic sequence
	 * 
	 *  You are forbidden to use the arithmeticList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 */
	public int[] arithmeticArray(int start, int diff, int n) {
		int[] finalArray = new int[n];
		if(n>0) {
		finalArray[0] = start;
		arithmeticArrayHelper( 1, diff, finalArray, n);
		}
		return finalArray;
	}

	/*
	 * This is a recursive helper method expected to be used by arithmeticArray.
	 * 
	 * Parameters:
	 * `i`: position in `seq` to be assigned to
	 * `diff`: common difference of the arithmetics sequence 
	 * `seq`: a partially filled arithmetic sequence
	 *  
	 * Each recursive call to this helper method stores at index `i` of the resulting
	 * arithmetic sequence `seq`, which is assumed to have been partially filled at indices 0, 1, ..., i - 1. 
	 */
	private void arithmeticArrayHelper(int i, int diff, int[] seq, int n) {
            if(i>=n) {
                //stop execution
        } else if(seq.length == 0){ //first element
            seq[0] = diff;
            arithmeticArrayHelper(i+1, diff, seq, n);
            
        } else {
            seq[i] = seq[i-1]+diff;
            arithmeticArrayHelper(i+1, diff, seq, n);
        }
    }
}
