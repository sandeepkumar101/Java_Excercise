package common;

import java.util.Arrays;
 /**
     * Write a function that accepts 2 inputs:
     * (1) an array of integers
     * (2) integer n
     * And that returns the n-th largest value.
     * 
     * Sample array is [4, 2, 4, 5, 1]
     * If n = 1, return largest value => 5
     * If n = 2, return 2nd-largest value => 4
     * If n = 3, return 3rd-largest value => 2
     * If n = 4, return 4th-largest value => 1
     * 
     * The array may contain duplicate values, but it will have no null entries or
     * undefined values.
     * It is safe to assume that n is not larger than the length of the input array.
     * 
     * An optimal solution is nice, but it is more important to have a working
     * solution first.
     * Focus on improving the performance after developing a working algorithm.
     * 
     * It is acceptable to look up syntax or existing language functions, but please
     * do not search for an answer to the question itself.
     * 
     * 
     */
public class KthLargestNumber {
    public static void main(String[] args) {
        int[] nums = { 4, 2, 4, 5, 1, -1, 0 };
        System.out.println(solution(nums, 3));
    }

    public static int solution(int[] nums, int n) {
        if (nums == null || nums.length < 1)
            new IllegalArgumentException("Invalid arg");

        // Sort
        Arrays.sort(nums); // nlog(n) //n
        System.out.println(Arrays.toString(nums));
        int index = nums.length - 1; // 1
        int currentValue = nums[index]; // 1

        while (n > 1 && index > 0) { // n
            index--;
            if (currentValue != nums[index]) {
                currentValue = nums[index];
                n--;
            }
        }
        return currentValue; // nlog(n) //n
    }
}
