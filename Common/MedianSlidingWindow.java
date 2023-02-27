package Common;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MedianSlidingWindow {

    /**
     * Statement Given an integer array n u m s nums and an integer k k , there is a
     * sliding window of size k k which is moving from the very left of the array to
     * the very right. You can only see the k k numbers in the window. Each time the
     * sliding window moves right by one position, return the median of the current
     * window. Answers within 1 0 − 5 10 −5 of the actual value will be accepted.
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(1 / 2);
        int[][] arr = { {2147483647, -14756, 21474, -2147483646, -2147483647, -5555, 9999, 78967},{ 3, 4, 5, 1, 8, -3, 5, -4 }, { 1, 3, -1, -3, 5, 3, 6, 7 }, { 1, 2 }, { 4, 7, 2, 21 },
                { 22, 23, 24, 56, 76, 43, 121, 1, 2, 0, 0, 2, 3, 5 }, { 1, 1, 1, 1, 1 } };
        int[] k = {7, 4, 3, 1, 2, 5, 2 };
        for (int i = 0; i < k.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput array =" + Arrays.toString(arr[i]) + ", k = " + k[i]);
            double[] output = medianSlidingWindowSolution(arr[i], k[i]);
            System.out.println("\tMedians =" + Arrays.toString(output));

        }

    }

    /**
     * 
     * @param nums
     * @param k
     * @return
     */
    public static double[] medianSlidingWindowSolution(int[] nums, int k) {
        // Your code will replace this placeholder return statement
        if (nums.length == 0) {
            return new double[] {};
        }
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> min = new PriorityQueue<Integer>();
        PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
        int j = 0;
        for (int i = 0; i < k; i++) {
            min.offer(nums[i]);
        }
        for (int i = 0; i < k / 2; i++) {
            max.offer(min.poll());
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = k; i < nums.length; i++, j++) {
            if (k % 2 > 0) {
                result[j] = (double) min.peek();
            } else {
                result[j] = ((double) min.peek() + (double) max.peek()) * 0.5;
            }
            if (nums[i] > min.peek()) {
                min.offer(nums[i]);
                minRebalance(min, max);

            } else {
                max.offer(nums[i]);
                maxRebalance(min, max);
            }

            map.put(nums[i - k], map.getOrDefault(nums[i - k], 1));

            if (map.getOrDefault(min.peek(), 0) > 0) {
                Integer temp = min.poll();
                map.put(temp, map.get(temp) - 1);
                maxRebalance(min, max);
            }
            if (map.getOrDefault(max.peek(), 0) > 0) {
                Integer temp = max.poll();
                map.put(temp, map.get(temp) - 1);
                minRebalance(min, max);
            }

        }
        if (k % 2 > 0) {
            result[j] = (double) min.peek();
        } else {
            result[j] = ((double) min.peek() + (double) max.peek()) * 0.5;
        }

        return result;
    }

    public static void maxRebalance(PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
        int balance = max.size() - min.size();
        while (balance > 0) {
            min.offer(max.poll());
            balance = max.size() - min.size();
        }
    }

    public static void minRebalance(PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
        int balance = min.size() - max.size();
        while ((balance / 2) > 0) {
            max.offer(min.poll());
            balance = min.size() - max.size();
        }
    }
}
