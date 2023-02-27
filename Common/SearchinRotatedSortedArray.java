package Common;

import java.util.Arrays;

public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        int res[] = { 4,5,0,9,34,5,4,54,56,5,7,57,6,7,0,1,2 };
        Arrays.sort(res);
        System.out.println(search1(res, 6));
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

    public static int search1(int[]  nums, int target){

        int start = 0;
        int end = nums.length - 1;
        int pivot = findPivot(nums);
        System.out.println(pivot);
        if(pivot == -1)
            return binarySearch(nums, start, end, target);
        else if(target == nums[pivot])
            return pivot;
        else if(target < nums[pivot])
            return binarySearch(nums, start, pivot - 1, target);
        else
            return binarySearch(nums, pivot + 1, end, target);

    }

    public static int findPivot(int[] nums)
    {
        int left = 0;
        int right = nums.length - 1;

        int mid = -1;
        while(left<right){
            mid = left +(right-left)/2;
           if(nums[mid]>nums[left])
                right = mid - 1;
            else 
                left = mid+1;            
        }
        return mid;
    }


    public static int binarySearch(int[] nums, int left, int right, int target)
    {
        while(left<right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid]< target)
                right = mid + 1;
            else
                left = mid;

        }
        return -1;
    }
}

