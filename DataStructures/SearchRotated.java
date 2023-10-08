package datastructures;

import java.util.Arrays;

public class SearchRotated {
    public static void main(String[] args) {
        int[] targetList = {3, 6, 3, 6};
        int[][] numsList = {{6, 7, 1, 2, 3, 4, 5}, {6, 7, 1, 2, 3, 4, 5}, {4, 5, 6, 1, 2, 3},
                {4, 5, 6, 1, 2, 3}};

        for (int i = 0; i < targetList.length; i++) {
            System.out.println((i + 1) + ". Rotated array: " + Arrays.toString(numsList[i]));
            System.out.println("   target " + targetList[i] + " found at index "
                    + binarySearchRotated(numsList[i], targetList[i]));
            System.out.println(
                    "----------------------------------------------------------------------------------------------------\n");
        }
    }
    static int binarySearchRotated(int[] nums, int target) {
		// TODO: Write - Your - Code
		int left = 0;
        int right = nums.length-1;
        int pivate = pivate(nums);
        System.out.println("pivate:"+pivate);
        if(nums[0]>=target)
        {
            right = pivate-1;
        }
        else
        {
            left = pivate;
        }

        while(left<right){
            int mid = left + (right -left)/2;
            if(nums[mid] == target)
            {
                return mid;
            }
            if(nums[mid] > target)
            {
                right = mid-1;
            }
            else 
            {
                left = mid+1;
            }
        }
        return -1;
	}

    static int pivate(int[]  nums)
    {
        int left = 0;
        int right = nums.length - 1;

        int mid = -1;
        while(left<right){
            mid = left +(right-left)/2;
           if(nums[mid]<nums[left])
                right = mid;
            else 
                left = mid+1;            
        }
        return mid;
    }
}
