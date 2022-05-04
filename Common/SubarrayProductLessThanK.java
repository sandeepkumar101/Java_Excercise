package Common;
public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        int res[] = { 10,9,10,4,3,8,3,3,6,2,10,10,9,3 };
        System.out.println(numSubarrayProductLessThanK(res, 19));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0;
        int cur = 0;

        int ans = 0;
        //if (nums[start] < k) {
       //     ans++;
       // }

        while (cur <= nums.length - 1) {
            // if(nums[cur]<k)
            // {
            // ans++;
            // }
            int backindex = start;

            while (backindex <= cur) {
                int product = 1;
                System.out.println("");
                for (int i = backindex; i <= cur; i++) {
                    product *= nums[i];
                    System.out.print(nums[i] + ", ");
                }
                
                if (product < k) {
                    ans++;
                    System.out.println(", product:"+product + ", ans added");
                }
                else{
                    System.out.println(", product:"+product + ", ans not added");
                
                }
                backindex++;
            }
            cur++;
        }
        return ans;
    }

    /**
    Sliding window - If by adding the next element, the product remains less than k, pair this new element with all members in current window by appending the size of current window to answer.
    
    
    If window product remains greater after adding the current element, try removeing elements till the time the product is >= k.
    **/
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        if(k<2) return 0;
        
        int ans =0, i =0, j =0, prod =1;
        
        while(j < nums.length){
            prod = prod * nums[j];
            
            while(prod >= k){
                prod=prod/nums[i];
                ++i;
            }
            
            ans = ans + (j-i + 1);
            ++j;
        }
        
        return ans;
    }
}
