package Common;
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int res[] = { 1, 2, 3, 4, 5 };
        System.out.println(minSubArrayLen(11, res));

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int c = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) {
                c = Math.min(c, i - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return c == Integer.MAX_VALUE ? 0 : c;
    }
}
