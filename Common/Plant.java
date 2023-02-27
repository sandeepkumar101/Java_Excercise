package Common;

import java.util.Arrays;

public class Plant {
    public static void main(String[] args) {
        int[][] height = { { 4, 5, 3, 7, 2, 1, 9 },
                { 6, 4, 5, 3, 7, 2, 1, 9 },
                { 4, 5, 3, 7, 2, 1 } };
        Arrays.asList(height).forEach(e -> System.out.println(solution1(e)));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length == 1)
            return 0;

        int removeCount = 0;
        int pick = 0;
        int i = 1;
        if (!checkPickOrVelly(A[i - 1], A[i], A[i + 1])) {
            removeCount++;
        }
        i++;
        while (i < A.length - 1) {

            if (checkPickOrVelly(A[i - 1], A[i], A[i + 1])) {
                if (removeCount > 0) {
                    removeCount = 0;
                    pick++;
                }
            }
            if (checkPickOrVelly(A[i - 2], A[i], A[i + 1])) {
                removeCount++;
            } else if (checkPickOrVelly(A[i - 2], A[i - 1], A[i + 1])) {
                removeCount++;
            } else {
                return -1;
            }
            i++;
        }

        return removeCount;
    }

    public static boolean checkPickOrVelly(int previus, int current, int next) {
        if (previus > current && current < next) {
            return true;
        } else if (previus < current && current > next) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] slopeDirection(int[] nums) {
        int[] result = new int[nums.length];
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= current) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
            current = nums[i];
        }
        return result;
    }

    public static int solution1(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int[] result = slopeDirection(nums);
        System.out.println(Arrays.toString(result));
        int peak = 0;
        int current = result[0];
        for (int i = 1; i < result.length; i++) {
            if (current > result[i]) {
                peak++;
            }
            current = result[i];
        }
        if (result[result.length - 1] == 1)
            peak++;
        return peak;
    }
}
