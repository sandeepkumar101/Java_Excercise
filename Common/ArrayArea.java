package Common;
//Container With Most Water
//https://leetcode.com/problems/container-with-most-water/

public class ArrayArea {
    public static void main(String[] args) {
        int[] ints = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int maxArea = maxArea(ints);
        System.out.println(maxArea);
    }

    public static int maxArea1(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        if (height == null || height.length < 2)
            return 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                System.out.println("area:" + area);
                System.out.println("maxArea" + maxArea);
                System.out.println("i:" + i + ", value:" + height[i]);
                System.out.println("j:" + j + ", value:" + height[j]);
                maxArea = Math.max(maxArea, area);
                /*
                 * if(maxArea<area)
                 * {
                 * 
                 * maxArea = area;
                 * System.out.println("maxArea Changed:"+maxArea);
                 * left = i;
                 * right = j;
                 * }
                 */
            }
        }

        return maxArea;

    }

    public static int maxArea(int[] height) {

        if (height == null || height.length < 2)
            return 0;
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] <= height[right])
                left++;
            else
                right--;
        }
        return maxArea;

    }
}
