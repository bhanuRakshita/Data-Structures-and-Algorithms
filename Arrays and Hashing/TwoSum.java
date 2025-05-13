import java.util.HashMap;

public class TwoSum {

    //Soln using brute force
    //O(n^2)
    public int[] twoSumBruteForce(int[] nums, int target) {
        if(nums.length < 2){
            return new int[0];
        }
        for(int i=0; i<nums.length; i++ ){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    //Soln using hashMap
    //O(n)
    public int[] twoSumHashMap(int[] nums, int target){
        //create hash map value->index
        HashMap<Integer, Integer> values = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            values.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++){
            int diff = target-nums[i];
            if(values.containsKey(diff) && values.get(diff)!=i){
                return new int[]{i, values.get(diff)};
            }
        }
        return new int[0];
    }
}
