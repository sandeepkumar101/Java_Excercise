package common;
//Trapping Rain Water

//https://leetcode.com/problems/trapping-rain-water/

public class TrappingRainWater {
    public static void main(String[] args) {
        // int[] ints = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int[] ints = { 0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2 };
        // int[] ints = {4,2,0,3,2,5};
        int trap = trap3(ints);
        System.out.println(trap);
        trap = trap2(ints);
        System.out.println(trap);
        trap = trap4(ints);
        System.out.println(trap);
        trap = trap5(ints);
        System.out.println(trap);
    }

    public static int trap(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int left = 0;
        int right = 1;
        int tap = 0;
        while (height[left] < height[right]) {
            left++;
            right++;
            System.out.println("left:" + left + ", value:" + height[left]);
        }
        for (int i = left; i < height.length && right < height.length;) {
            if (height[i] > height[right]) {
                right++;
            } else {
                int maxTap = Math.min(height[i], height[right]);
                for (int j = i + 1; j < right; j++) {
                    System.out.println("j:" + j + ", value:" + (maxTap - height[j]));
                    tap += maxTap - height[j];
                }
                i = right;
                right = i + 1;

            }
        }
        return tap;
    }

    public static int trap1(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int left = 0;
        int right = 1;
        int tap = 0;
        int base = 0;
        int baseIndex = 0;
        while (height[left] < height[right]) {
            left++;
            right++;
            System.out.println("left:" + left + ", value:" + height[left]);
        }
        for (int i = left; i < height.length && right < height.length;) {
            System.out.println("i:" + i + ", value:" + height[i]);
            System.out.println("right:" + right + ", value:" + height[right]);
            if (height[right - 1] > height[right]) {
                right++;

            } else {
                int maxTap = Math.min(height[i], height[right]);
                System.out.println("maxTap:" + maxTap);
                System.out.println("base:" + base);
                for (int j = right - 1; height[j] <= height[right] && j > i; j--) {
                    System.out.println("j:" + j + ", value:" + (maxTap - Math.max(height[j], base)));
                    if (baseIndex >= j)
                        tap += maxTap - Math.max(height[j], base);
                    else
                        tap += maxTap - height[j];
                }

                if (height[i] <= height[right]) {
                    i = right;
                    right = i + 1;
                    base = 0;
                } else {
                    baseIndex = right;
                    base = maxTap;
                    right++;
                }

            }
        }
        return tap;
    }

    public static int trap3(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int left = 0;
        int right = 0;
        int tap = 0;
        int base = 0;
        int baseIndex = 0;
        // while (height[left] < height[right]) {
        // left++;
        // right++;
        // System.out.println("left:" + left + ", value:" + height[left]);
        // }

        for (int i = left; i < height.length; i++) {
            if (i > right) {
                right++;
                for (int j = i + 1; j < height.length; j++) {
                    if (height[right] <= height[j]) {
                        right = j;
                    }
                    // right = Math.max(height[right], height[j]);
                }
            }

            if (height[left] < height[i]) {
                left = i;
            }
            // left = Math.max(height[left], height[i]);
            if (right < height.length) {
                int ht = Math.min(height[left], height[right]);
                if (ht > 0)
                    tap = tap + ht - height[i];
            }
        }
        return tap;
    }

    public static int trap2(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int leftP = 0;
        int leftMaxP = 0;
        int rightP = height.length - 1;
        int rightMaxP = height.length - 1;
        int tap = 0;
        while (leftP < rightP) {
            if (height[leftP] <= height[rightP]) {
                if (height[leftMaxP] <= height[leftP]) {
                    leftMaxP = leftP;
                } else {
                    tap = tap + height[leftMaxP] - height[leftP];
                }
                leftP++;
            }

            else {
                if (height[rightMaxP] <= height[rightP]) {
                    rightMaxP = rightP;
                } else {
                    tap = tap + height[rightMaxP] - height[rightP];
                }

                rightP--;

            }
        }
        return tap;
    }

    public static int trap4(int[] height) {
        int tappingWater = 0;
        int left = 0;
        int right = 1;
        while (right < height.length) {
            if (height[left] < height[right]) {
                int index = right - 1;
                while (left < index) {
                    tappingWater += height[left] - height[index];
                    index--;
                }
                left = right;
            }

            right++;
        }
        return tappingWater;
    }

    public static int trap5(int[] height) {
        int tappingWater = 0;
        int leftMax = 0;
        int rightMax = 0;
        int currentPointer = 0;
        while (currentPointer < height.length) {
            if (currentPointer > rightMax) {
                rightMax = currentPointer;
                int index = rightMax + 1;
                while (index < height.length) {
                    if (height[rightMax] <= height[index]) {
                        rightMax = index;
                    }
                    index++;
                }
            }
            if (height[leftMax] <= height[currentPointer]) {
                leftMax = currentPointer;
            }
            // System.out.println("Current:" + currentPointer + "-" +
            // height[currentPointer]);
            int currentWater = Math.min(height[leftMax], height[rightMax]) - height[currentPointer];
            // System.out.println("currentWater:" + currentWater);
            if (currentPointer > 0)
                tappingWater += currentWater;

            currentPointer++;
        }
        return tappingWater;
    }

}
