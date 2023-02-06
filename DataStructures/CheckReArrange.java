package DataStructures;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Problem Statement
 * In this problem, you have to implement the void reArrange(int[] arr) method,
 * which will sort the elements,
 * such that all the negative elements appear at the left
 * and positive elements appear at the right.
 */
public class CheckReArrange {

    public static void main(String[] args) {
        int[] arr = {2, 4, -6, 8, -5, -10};

    System.out.print("Array before re-arranging: ");
    System.out.println(Arrays.toString(arr));
    System.out.println();
    reArrange(arr);
    System.out.print("Array after rearranging: ");
    System.out.println(Arrays.toString(arr));
    }

    public static void reArrange(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (arr[left] < 0 && left < right)
                left++;
            while (arr[right] > 0 && right > left)
                right--;

            if (arr[left] > 0 && arr[right] < 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        // Write - Your - Code
    }

}
