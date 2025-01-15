package twopointer;

import java.util.Arrays;

public class SortColor {
    public static void main(String[] args) {

        int[] colors = { 2, 1, 1, 0, 0 };
        System.out.println(sortColors(colors));
    }
    public static int[] sortColors(int[] colors) {
        int red = 0;
        int white = 1;
        int blue = 2;
        int redIndex = 0;
        int blueIndex = colors.length-1;
        int i = 0;
        while(i <= blueIndex) {
            if (colors[i] == red) {
                swap(colors, redIndex, i);
                i++;
                redIndex++;
            }
            else if (colors[i] == blue) {
                swap(colors, i, blueIndex);
                blueIndex--;
            }
            else if(colors[i] == white){
                i++;
            }
        }
        // Write your code here
        return colors;
    }

    public static int[] sortColors2(int[] colors) {
        int red = 0;
        int white = 1;
        int blue = 2;
        int redIndex = -1;
        int whiteIndex = 0;
        int blueIndex = colors.length;
        /*
         * for (int i = 0; i < colors.length; i++) {
         * if(colors[i] == red)
         * redIndex++;
         * else
         * break;
         * }
         * for (int i = colors.length-1; i >= 0; i--) {
         * if(colors[i] == blue)
         * blueIndex--;
         * else
         * break;
         * }
         */

        for (int i = redIndex + 1; i < blueIndex;) {
            if (colors[i] == red) {
                swap(colors, i, ++redIndex);
                // continue;
            }
            if (colors[i] == blue) {
                swap(colors, i, --blueIndex);
                // continue;
            }
            if (colors[i] == white || i == redIndex) {
                i++;
            }
        }

        // Write your code here
        return colors;
    }

    public static void swap(int[] colors, int from, int to) {
        if (from == to)
            return;
        if (from < 0 || from >= colors.length) {
            return;
        }
        if (to < 0 || to >= colors.length) {
            return;
        }
        int temp = colors[from];
        colors[from] = colors[to];
        colors[to] = temp;
    }
}
