package DataStructures;

/**
 * Problem Statement
 * In this problem, you have to implement the void maxMin(int[] arr) method.
 * This will re-arrange the elements of a sorted array in such a way
 * that the first position will have the largest number,
 * the second will have the smallest, the third will have the second-largest,
 * and so on.
 * 
 * Note: The given array is sorted in ascending order.
 * Note: The range of integers in the array can be from 0 to 10000.
 */
public class CheckMaxMin {

    public static void maxMin(int[] arr) {
        int[] result = new int[arr.length];
        int smallest = 0;
        int largest = arr.length - 1;
        int k = 0;
        while (smallest <= largest) {
            result[k++] = arr[largest--];
            result[k++] = arr[smallest++];
        }
        if (smallest == largest)
            result[k] = arr[smallest];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
        // Write - Your - Code
    }
}
