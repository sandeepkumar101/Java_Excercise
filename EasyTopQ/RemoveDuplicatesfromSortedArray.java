package EasyTopQ;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
 */

public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        int[] expectedNums = { 1, 2 };
        int k = removeDuplicates(nums);
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }

    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null)
            return 0;
        if(nums.length<2)
            return 1;
        int current = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[current] != nums[i]) {
                current++;
                nums[current] = nums[i];
            }
        }
        current++;
        return current;
    }
}
