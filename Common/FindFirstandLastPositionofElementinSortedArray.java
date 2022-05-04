package Common;
import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {
    public static void main(String[] args) {
        int[] res = { 5, 7, 7, 8, 8, 10 };
        System.out.println(Arrays.toString(searchRange(res, 8)));

    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        ans[0] = search(nums, target, true);
        if (ans[0] != -1) {
            ans[1] = search(nums, target, false);
        }
        return ans;
    }

    public static int[] searchRange1(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };
        if (nums == null || nums.length == 0) {
            return result;
        }
        int mid = (nums.length - 1) / 2;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            mid = right / 2 + left / 2;
            if (nums[mid] == target) {
                int i = mid;
                int j = mid;
                while (i - 1 >= 0 && nums[i - 1] == target) {
                    i--;
                }
                while (j + 1 < nums.length && nums[j + 1] == target) {
                    j++;
                }
                // return new int[] { i, j };
                result = new int[] { i, j };
                break;
            }
            if (nums[mid] > target) {
                // nums = Arrays.copyOfRange(nums,0,mid);
                right = mid;
            } else {
                // nums = Arrays.copyOfRange(nums,mid+1,nums.length);
                left = mid + 1;
            }
        }

        return result;
    }

    public static int[] findFirstLastIndex(int[] nums, int index) {
        int left = index;
        int right = index;
        while (left - 1 >= 0 && nums[left - 1] == nums[index]) {
            left--;
        }
        while (right + 1 < nums.length && nums[right + 1] == nums[index]) {
            right++;
        }
        return new int[] { left, right };
    }

    public int[] searchHelper(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] output = new int[2];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                output = findFirstLastIndex(nums, mid);
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return output;

    }

    public static int search(int[] arr, int target, boolean findStartIndex) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
