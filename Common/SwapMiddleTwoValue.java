package Common;

/*
 * Click `Run` to execute the snippet below!
 * NetSpoke - Screening
 */

import java.io.*;
import java.util.*;

// Problem: Swap the location of the middle two values in an unordered array of integers.
//
// Example:
// [4, -5, 9, -18] -> [-5, 4, 9, -18]
//
// [2, 3, -22, 6, -32, 0] -> [0, 3, -22, 6, -32, 2]
//
// [-34, -37, -24, 17, -23, 22, -89, -77] -> [-24, -37, -34, 17, -23, 22, -89, -77]
//
class SwapMiddleTwoValue {
    public static void main(String[] args) {
        int[] testCase1 = { 4, -5, 9, -18 };

        int[] testCase2 = { 2, 3, -22, 6, -32, 0 };

        int[] testCase3 = { -34, -37, -24, 17, -23, 22, -89, -77 };

        SwapMiddleTwoValue sol = new SwapMiddleTwoValue();

        System.out.println(Arrays.toString(sol.revertMidValues(testCase1)));
        System.out.println(Arrays.toString(sol.revertMidValues(testCase2)));
        System.out.println(Arrays.toString(sol.revertMidValues(testCase3)));
    }

    int[] revertMidValues(int[] array) {
        int[][] mat = new int[array.length][2];

        for (int i = 0; i < array.length; i++) {
            mat[i][0] = array[i];
            mat[i][1] = i;
        }

        Arrays.sort(mat, (x, y) -> Integer.compare(x[0], y[0]));

        int index = array.length / 2;

        int temp = array[mat[index][1]];
        array[mat[index][1]] = array[mat[index - 1][1]];
        array[mat[index - 1][1]] = temp;
        return array;
    }

}
