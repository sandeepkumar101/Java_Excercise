package twopointer;

import java.util.*;

public class SumOfThree {
    public static void main(String[] args) {
        SumOfThree sumOfThree = new SumOfThree();
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println(sumOfThree.findSumOfThree(nums, 0));

        int[] nums1 = { 1, 2, 3, 5, 6, 4, 7, 8, 9, 5, 62, 3, 6, 7, 2 };
        System.out.println(sumOfThree.findSumOfThree(nums1, 74));

        int[] nums2 = { 1, 0, -1 };
        System.out.println(sumOfThree.findSumOfThree(nums2, -1));

        int[] nums3 = { -1, 2, 1, -4, 5, -3 };
        System.out.println(sumOfThree.findSumOfThree(nums3, 0));

    }

    public static boolean findSumOfThree(int[] nums, int target) {
        // Sort the array first

        if (nums.length < 3) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums); // -4,-3,-1,1,2,5
        while (right - left > 1) {

            int innerleft = left + 1;
            int innerright = right - 1;
            int thirdsum = nums[left] + nums[right] + nums[innerleft];
            
            while (innerleft <= innerright) {
                thirdsum = nums[left] + nums[right] + nums[innerleft];
                if (thirdsum == target) {
                    return true;
                }
                if (target > thirdsum)
                    innerleft++;
                else
                    innerright--;
            }
            if (target > thirdsum)
                left++;
            else
                right--;
        }
        // Replace this placeholder return statement with your code
        return false;
    }
}
