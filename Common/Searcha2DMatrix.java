package common;
import java.util.Arrays;
import java.util.stream.Stream;

public class Searcha2DMatrix {
    public static void main(String[] args) {
        // matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        int matrix[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 300;
        System.out.println(searchMatrix(matrix, target));

    }

    public static boolean searchMatrix1(int[][] matrix, int target) {
        int[] intflat = Stream.of(matrix).flatMapToInt(mapper -> Arrays.stream(mapper)).toArray();
        int left = 0;
        int right = intflat.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intflat[mid] == target)
                return true;
            if (intflat[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    // Faster solution
    public static boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;
        while (left <= n) {
            int mid = left + (n - left) / 2;
            if (matrix[mid][0] == target || matrix[mid][m] == target)
                return true;
            if (matrix[mid][0] < target && matrix[mid][m] > target)
                return search(matrix[mid], target);
            else if (matrix[mid][0] > target) {
                n = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return false;
    }

    public static boolean search(int[] muns, int target) {
        int left = 0;
        int right = muns.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (muns[mid] == target)
                return true;
            if (muns[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}
