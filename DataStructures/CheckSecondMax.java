package DataStructures;

public class CheckSecondMax {
    public static String arrayToString(int arr[]) {
        if (arr.length > 0) {
            String result = "";
            for (int i = 0; i < arr.length; i++) {
                result += arr[i] + " ";
            }
            return result;
        } else {
            return "Empty Array!";
        }
    }

    public static void main(String args[]) {

        int[] arr = { -2, -33, -10, -456 };

        System.out.println("Array: " + arrayToString(arr));

        int secMax = findSecondMaximum(arr);

        System.out.println("Second maximum: " + secMax);

    }

    public static int findSecondMaximum(int[] arr) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstMax) {
                secondMax = firstMax;
                firstMax = arr[i];
            } else if (arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }
        // Write - Your - Code
        return secondMax;
    }
}
