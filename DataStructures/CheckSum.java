package datastructures;

import java.util.Arrays;

/**
 * In this problem, you have to implement the
 * int[] findSum(int[] arr, int n) method,
 * which will take a number n, and an array arr as
 * input and returns an array of two integers that
 * add up to n in an array. You are required to
 * return only one such pair. If no such pair is found
 * then simply return the array.
 */

public class CheckSum {

    public static void main(String args[]) {

        int n = 9;
        int[] arr1 = { 1, 2, 3, 4, 5 };
        if (arr1.length > 0) {
            int[] arr2 = findSum1(arr1, n);
            int num1 = arr2[0];
            int num2 = arr2[1];

            if ((num1 + num2) != n)
                System.out.println("Not Found");
            else {
                System.out.println("Number 1 = " + num1);
                System.out.println("Number 2 = " + num2);
                System.out.println("Sum = " + (n));

            }
        } else {
            System.out.println("Input Array is Empty!");
        }
    }

    public static int[] findSumOld(int[] arr, int n) {
        int[] pair = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == n) {
                    pair[0] = arr[i];
                    pair[1] = arr[j];
                    return pair;
                }
            }
        }
        return pair;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivate = arr[high];
        int i = low - 1; // Smaller value indexProductArray
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivate) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // Swap
        int temp = arr[high];
        arr[high] = arr[i + 1];
        arr[i + 1] = temp;
        return i + 1;
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            quicksort(arr, low, partition - 1);
            quicksort(arr, partition + 1, high);
        }
    }

    public static int[] findSum(int[] arr, int n) {
        int[] pair = new int[2];
        int first = 0;
        int last = arr.length - 1;
        quicksort(arr, first, last);

        while (first < last) {
            int sum = arr[first] + arr[last];
            if (sum == n) {
                pair[0] = arr[first];
                pair[1] = arr[last];
                return pair;
            }
            if (sum > n) {
                last--;
            } else {
                first++;
            }
        }
        return arr;
    }

    //
    public static int[] findSum1(int[] arr, int n) {
        Arrays.sort(arr);
        int[] pair = new int[2];
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int sum = arr[start] + arr[end];
            if (sum == n) {
                pair[0] = arr[start];
                pair[1] = arr[end];
                break;
            } else if (sum > n) {
                end--;
            } else {
                start++;
            }
        }
        return pair;
    }
}
