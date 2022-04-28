import java.util.*;

class KthSmallestNumber {

    public static int findKthSmallestNumber(int[] nums, int k) {
        int[] kelements = new int[k];
        Arrays.fill(kelements, Integer.MAX_VALUE);
        // TODO: Write your code here
        for (int i : nums) {
            setSmaller(i, kelements);
        }

        return kelements[k - 1];
    }

    public static void setSmaller(int v, int[] k) {
        for (int i = 0; i < k.length; i++) {
            if (v < k[i]) {
                int t = k[i];
                k[i] = v;
                v = t;
            }
        }
    }

    public static void main(String[] args) {
        int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers
        // should be a '5'
        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}