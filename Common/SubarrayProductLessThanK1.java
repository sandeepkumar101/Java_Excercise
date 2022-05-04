package Common;
public class SubarrayProductLessThanK1 {
 
    public static void main(String[] args) {
        
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0;
         //Arrays.sort(nums);
         int ans = 0;
         int prod= 1;
         for(int i=0;i<nums.length;i++) {
             prod *= nums[i];
             while(prod >= k && start <= i) {
                 prod /= nums[start];
                 start++;
             }
             ans += i - start + 1;
         }
         
         return ans; 
     }
}
