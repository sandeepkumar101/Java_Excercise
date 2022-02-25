public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        int res[] = { 4,5,6,7,0,1,2 };
        System.out.println(search(res, 0));
    }

    public static int search(int[] nums, int target) {
        int start  = 0;
        int end = nums.length - 1;
        int ans = -1;
        if(nums.length == 0) return ans;

        while(start<=end)
        {
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                ans = mid;
                break;
            }
            if(nums[start] == target){
                ans = start;
                break;
            }
            if(nums[end] == target){
                ans = end;
                break;
            }
            if(nums[end]< nums[start])
            {
                
                if(target<nums[mid])
                {
                    if(target<nums[start])
                        start = mid + 1;
                    else
                        end = mid - 1;
                }
                else
                {
                    if(target>nums[end])
                        start = mid + 1;
                    else
                        end = mid - 1;
                }
            }
            else{
                if(target<nums[mid])
                {
                    end = mid - 1;
                }
                else
                {
                    start = mid + 1;
                }
            }
            }

        return ans;
    }
}

