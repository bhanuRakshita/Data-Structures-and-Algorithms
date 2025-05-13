package Recursion;

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

    
}
