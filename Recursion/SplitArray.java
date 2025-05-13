package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class SplitArray {
    /*
	 * Given an array of ints, 
	 * is it possible to divide the ints into two groups, 
	 * so that the sums of the two groups are the same. 
	 * 
	 * Every int must be in one group or the other. 
	 * 
	 * Write a recursive helper method that takes whatever arguments you like, 
	 * and make the initial call to your recursive helper from splitArray(). 
	 * (No loops needed.)
	 * 
	 * splitArray([2, 2]) → true
	 * splitArray([2, 3]) → false
	 * splitArray([5, 2, 3]) → true 
	 */
	public static boolean splitArray(int[] nums) {
		return splitArrayHelper(nums, new int[0], new int[0], 0, 0, 0);
	}

	private static boolean splitArrayHelper(int[] nums, int[] list1, int[] list2, int sum1, int sum2, int index) {
		if(index>=nums.length) { // added all elements
			if(sum1 == sum2) { //sum found
				return true;
			} else {    // sum not equal
				return false;
			}
		}
		
		//either add
		int[] newList1 = Arrays.copyOf(list1, (list1.length)+1);
		newList1[newList1.length-1] = nums[index];
		int[] newList2 = Arrays.copyOf(list1, (list1.length)+1);
		newList2[newList2.length-1] = nums[index];
		
		return splitArrayHelper(nums, newList1, list2, sum1+newList1[newList1.length-1], sum2, index+1) ||
				splitArrayHelper(nums, list1, newList2, sum1, sum2+newList2[newList2.length-1], index+1);
		
		
	}

    /*
	 * A useful extension to the original `splitArray` problem.
	 * 
	 * If a split of equal sums is possible, return an ArrayList of size 2: 
	 * 	- index 1 of the returned ArrayList stores the list of integers representing group 1.
	 * 	- index 0 of the returned ArrayList stores the list of integers representing group 1.
	 * 
	 * If a split is not possible, both indices store empty lists.
	 * 
	 * Requirements (as an example, see `testSplitArrayHarder_14` in RecursiveMethodTests): 
	 * 	When an equal split is possible, then:
	 * 		+ The first element of the input array `ns` (i.e., ns[0]) must be put into group1.
	 * 		+ The order in which elements appear in each group must be the same as they appear in the input array `ns`.
	 * 
	 * Assumption: when a split is possible, there is a single, unique split only.
	 * 
	 * Hints:
	 * 		+ Pass as arguments two empty lists, representing group1 and group2, to the call to a recursive helper method.
	 * 		+ Via call by value, the two lists should be modified properly among as the recursion tree is built.
	 * 		+ Upon the call terminating, return a list containing the two modified lists.      		  
	 */
	public static ArrayList<ArrayList<Integer>> splitArrayHarder(int[] nums){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		Boolean bool = splitArrayHarderHelper(nums, new ArrayList<Integer>(), 0, new ArrayList<Integer>(), 0, 0, result);
		
		if(!bool) {
			result.add(new ArrayList<Integer>());
			result.add(new ArrayList<Integer>());
		}
		return result;
	}
	
	private static boolean splitArrayHarderHelper(int[] nums, ArrayList<Integer> l1, int sum1, ArrayList<Integer> l2, int sum2, int index, ArrayList<ArrayList<Integer>> result) {
		if(index>=nums.length) {
			if(sum1==sum2) {
				result.add(l1);
				result.add(l2);
				return true;
			}
			else {
				return false;
			}
		}
		//add to l1;
		ArrayList<Integer> newL1 = new ArrayList<>(l1);
		newL1.add(nums[index]);
		
		//add to l2;
		ArrayList<Integer> newL2 = new ArrayList<>(l2);
		newL2.add(nums[index]);
		
		return splitArrayHarderHelper(nums, newL1, sum1+nums[index], l2, sum2, index+1, result) || 
		       splitArrayHarderHelper(nums, l1, sum1, newL2, sum2+nums[index], index+1, result);
		
	}


}
