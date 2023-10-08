package common;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/submissions/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        
        if(nums == null || nums.length <2)
            return null;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< nums.length; i++)
        {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    
        
    
}
