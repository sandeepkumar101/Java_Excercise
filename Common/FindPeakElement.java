package common;
public class FindPeakElement {
    public static void main(String[] args) {
        int res[] = { 1, 7, 3, 1, 4,1,6,2 };
        System.out.println(findPeakElement2(res));
    }

    public static int findPeakElement1(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return 0;
        if (nums.length == 2)
            return nums[0] > nums[1] ? 0 : 1;

        if (nums[0] > nums[1])
            return 0;

        if (nums[end] > nums[end - 1])
            return end;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid - 1 >= 0 && nums[mid] > nums[mid - 1] && mid + 1 <= nums.length - 1 && nums[mid] > nums[mid + 1])
                return mid;
            else {
                if (start - 1 >= 0 && nums[start] > nums[start - 1] && start + 1 < nums.length
                        && nums[start] > nums[start + 1])
                    return start;
                else
                    start++;

                if (end + 1 < nums.length && end - 1 >= 0 && nums[end] > nums[end - 1] && nums[end] > nums[end + 1])
                    return end;
                else
                    end--;
            }

        }

        return -1;
    }

    // Faster solution
    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return 0;
        if (nums.length == 2)
            return nums[0] > nums[1] ? 0 : 1;
        
        if (nums[0] > nums[1])
            return 0;

        if (nums[end] > nums[end - 1])
            return end;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid - 1 >= 0 && nums[mid] > nums[mid - 1] && mid + 1 <= nums.length - 1 && nums[mid] > nums[mid + 1])
                return mid;
            else {
                if (start == 0) {
                    if (nums[0] > nums[1])
                        return 0;
                } else {
                    if (nums[start] > nums[start - 1] && start + 1 < nums.length && nums[start] > nums[start + 1])
                        return start;
                    else
                        start++;
                }

                if (end == nums.length - 1 && nums[end] > nums[end - 1]) {
                    if (nums[end] > nums[end - 1])
                        return end;
                } else {
                    if (end - 1 >= 0 && nums[end] > nums[end - 1] && nums[end] > nums[end + 1])
                        return end;
                    else
                        end--;
                }

            }

        }
        return -1;
    }
    //Leetcode solution
    public static int findPeakElement2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
