package easytopq;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 * 
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 * 
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * 
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        //quickSort(nums, 0, nums.length - 1);
        //System.out.println(Arrays.toString(nums));
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        //quickSort(nums, 0, nums.length-1);
        Arrays.sort(nums);
        int prev = nums[0];
        for(int i =1; i< nums.length;i++){
            if(prev == nums[i])
            {
                return true;
            }
            prev = nums[i];
        }
        return false;
    }

    /**
     * https://www.geeksforgeeks.org/quick-sort/?ref=lbp
     * 
     * @param nums
     * @param low
     * @param high
     */
    public static void quickSort(int[] nums, int low, int high) {

        if (low < high) {
            int pivot = findPivot(nums, low, high);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }

    }

    public static int findPivot(int[] nums, int low, int high) {
        int pivot = nums[high];
        int j = low;
        for (int i = low; i < high; i++) {
            if (nums[i] < pivot) {
                // spik is pointing to same element
                if (i != j) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
                j++;
            }
        }
        int temp = nums[j];
        nums[j] = nums[high];
        nums[high] = temp;
        return j;
    }

}
