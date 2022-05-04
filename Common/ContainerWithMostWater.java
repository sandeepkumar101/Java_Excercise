package Common;
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        if(height == null || height.length<2)
            return 0;
        int area = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            area = Math.max(area, Math.min(height[left], height[right])*(right-left));
            if(height[left]< height[right])
            {
                left++;
            }
            else{
                right--;
            }
        }
        return area;
    }
}
