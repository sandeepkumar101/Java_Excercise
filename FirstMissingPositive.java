public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] a = { 1, 1 };
        System.out.println(firstMissingPositive(a));
        int[] b = { 1,1,1,2,2,3 };
        System.out.println(removeDuplicates(b));
    }

    public static int firstMissingPositive1(int[] nums) {
        if (nums == null || nums.length < 1)
            return 1;
        int s = nums[0], l = nums[0], len = 0, sum = 0;
        for (int i : nums) {
            if (i >= 0) {
                s = Math.min(s, i);
                l = Math.max(l, i);
                len++;
                if (i > 0)
                    sum += i;
            }
        }
        // int sum = n(n+1)/2
        int ssum = 0;

        if (s >= 1) {
            ssum = ((s - 1) * ((s - 1) + 1) / 2);
        }
        int fsum = (l * (l + 1) / 2) - ssum;

        if (s < 0) {
            if (fsum - sum > 0)
                return fsum - sum;
            else
                return l + 1;
        } else {
            if (fsum == sum)
                return l + 1;
            else
                return fsum - sum;
        }
        /*
         * if (s > 1)
         * return 1;
         * if (l < 1)
         * return 1;
         * if (fsum == sum) {
         * if (s == 1)
         * return l + 1;
         * else
         * return s - 1;
         * } else {
         * if(fsum - sum>0)
         * return fsum - sum;
         * else
         * return l+1;
         * }
         */

    }

    public static int firstMissingPositive2(int[] nums) {
        // Math?

        // replace in place? that is not extra space
        // an array with len n, all possible numbers are 1->n+1

        // first scan, put numbers <= n in corresponding place
        // second scan, check which position is not the number expected

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // only check numbers within [1,n]
            if (nums[i] <= 0 || nums[i] > n) {
                continue;
            }
            // before replace the number, check if it is another qualify number, we don't
            // want to overwrite an qualify number
            if (nums[nums[i] - 1] < n && nums[nums[i] - 1] != nums[i]) {
                // swap the number and decrease i to re-check current location
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
                i--;
            } else {
                // overwrite number
                nums[nums[i] - 1] = nums[i];
            }
        }

        // now, check the array again to see which location has a miss match
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // all numbers are there
        return n + 1;
    }
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean[] bits = new boolean[len + 1];
        
        for (int n : nums) {
            if (n > 0 && n <= len) {
                bits[n] = true;    
            }
        }
        
        if (!bits[1]) {
            return 1;
        }
        
        for (int i = 2; i <= len; ++i) {
            if (!bits[i]) {
                return i;
            }
        }
        
        return len + 1;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        int currentvalue = nums[0];
        int dupCount = 0;
        int dupAlloved = 0;
        //int[] result = new int[nums.length];
        //result[0] = nums[0];
        for(int i= 1; i < nums.length; i++) {
            if(nums[i] == currentvalue) {
                if(dupAlloved <1) {
                    dupAlloved++;
                    
                }
                else {
                    dupCount++;
                    continue;
                }
            } else {
                currentvalue = nums[i];
                dupAlloved = 0;
            }
            nums[i - dupCount] = nums[i];
        }
        return nums.length - dupCount;   
    }

  //  T/S: O(n)/O(1), where n = size(nums)

public static int removeDuplicates2(int[] nums) {
	var n = nums.length;
	if (n < 3)
		return n;
		
	var i = 2;
	for (var j = i; j < n; j++)
		if (nums[j] != nums[i - 2])
			nums[i++] = nums[j];
			
	return i;
}
//Generic solution for when k repetitions are allowed

public static int removeDuplicates3(int[] nums, int k) {
	var n = nums.length;
	if (n < k + 1)
		return n;
		
	var i = k;
	for (var j = i; j < n; j++)
		if (nums[i - k] != nums[j])
			nums[i++] = nums[j];
			
	return i;
}
}
