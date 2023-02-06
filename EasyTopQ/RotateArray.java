package EasyTopQ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
 * Given an integer array nums, rotate the array to the right by k steps, where
 * k is non-negative.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * 
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        rotate2(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int newItem = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = newItem;
                newItem = temp;
            }
        }
    }

    public static void rotate2(int[] nums, int k) {
        if (k < 1)
            return;
        if (nums.length == k)
            return;
        if (nums.length == 1)
            return;
        //Skip the rotation of the array if steps are grater than the size of array
        if (nums.length < k)
            k = k%nums.length;

        Queue<Integer> q = new LinkedList<>();

        for (int i = k; i > 0; i--) {
            q.offer(nums[nums.length - (i)]);
        }
        for (int j = 0; j < nums.length; j++) {
            int temp = nums[j];
            nums[j] = q.poll();
            q.offer(temp);
        }
    }
}
