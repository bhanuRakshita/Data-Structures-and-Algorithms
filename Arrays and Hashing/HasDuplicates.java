import java.util.Arrays;
import java.util.HashSet;

public class HasDuplicates {

    //solution using brute force
    //O(n^2)
    public boolean hasDuplicateBruteForce(int[] nums) {
        for (int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    //Solution using sorting the array
    //O(nlogn)
    public Boolean hasDuplicateSorting(int[] nums) {
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++) {
            if(nums[i]==nums[i-1]){
                return true;
            }
        }
        return false;
    }

    //Solution using HashSet
    // O(n)
    public Boolean hasDuplicateHashSet(int[] nums){
        HashSet<Integer> seen = new HashSet<>();
        for(int n: nums){
            if(seen.contains(n)){
                return true;
            } else {
                seen.add(n);
            }
        } 
        return false;
    }

    //Solution using HashSet length
    //O(n)
    public Boolean hasDuplicateHashSetLength(int[] nums){
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
}
