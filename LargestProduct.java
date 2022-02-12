public class LargestProduct {
    public static void main(String[] args) {
        System.out.println(largestProductOfThree(new int[] { -10, -10, 5, 2, 2, 80 }));
        System.out.println(largestProductAll(new int[] { -10, -10, 5, 2, -2, 80, -1 }));
    }

    public static int largestProductAll(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxProduct = 1;
        int minProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                maxProduct *= nums[i];
                minProduct *= nums[i];
            } else if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = Math.max(minProduct * nums[i], maxProduct * nums[i]);
                minProduct = Math.min(temp * nums[i], minProduct * nums[i]);
            } else {
                maxProduct = 1;
                minProduct = 1;
            }
            max = Math.max(max, maxProduct);
            min = Math.min(min, minProduct);
        }
        return max;
    }

    public static int largestProductOfThree(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] * nums[1];
        }
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        int max = 0;
        int product = 1;
        int SECOND_MAX = 0;
        int Third_MAX = 0;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) > Math.abs(Third_MAX)) {
                max = SECOND_MAX;
                SECOND_MAX = Third_MAX;
                Third_MAX = nums[i];

            } else if (Math.abs(nums[i]) > Math.abs(SECOND_MAX)) {
                max = SECOND_MAX;
                SECOND_MAX = nums[i];
            } else if (Math.abs(nums[i]) > Math.abs(max)) {
                max = nums[i];
            }

        }
        product = max * SECOND_MAX * Third_MAX;
        return product;
    }
}
