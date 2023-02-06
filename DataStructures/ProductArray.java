package DataStructures;

import java.util.Arrays;

/**
 * In this problem, you have to implement the int[] findProduct(int[] arr)
 * method which will modify arr in such a way that in the output,
 * each index i will contain the product of all elements present
 * in arr except the element stored on that index i.
 * 
 */
public class ProductArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        findProduct(arr);
    }

    public static int[] findProduct(int arr[]) {
        int[] result = new int[arr.length];
        Arrays.fill(result, 1);
        int forward = 1;
        int backword = 1;
        for (int i = 0, j = arr.length - 1; i < arr.length && j >= 0; i++, j--) {
            result[i]*= forward;
            forward *= arr[i];
            System.out.println("i:" + i + "=" + Arrays.toString(result));
            
            result[j] *= backword;
            backword *= arr[j];
            System.out.println("j:" + j + "=" + Arrays.toString(result));
        }
        // write your code here

        return result;
    }

}
