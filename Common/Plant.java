package Common;
public class Plant {
    public static void main(String[] args) {
        int[] height = { 4, 5, 3, 7, 2, 1 };
        System.out.println(solution(height));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length == 1)
            return 0;

        int removeCount = 0;
        int pick = 0;
        int i = 1;
        if (!checkPickOrVelly(A[i - 1], A[i], A[i + 1])) {
            removeCount++;
        }
        i++;
        while (i < A.length - 1) {

            if (checkPickOrVelly(A[i - 1], A[i], A[i + 1])) {
                if (removeCount > 0) {
                    removeCount = 0;
                    pick++;
                }
            }

            // if (i == 1 && !checkPickOrVelly(A[i - 1], A[i], A[i + 1])) {
            // removeCount++;
            // } else {
            if (checkPickOrVelly(A[i - 2], A[i], A[i + 1])) {
                removeCount++;
            } else if (checkPickOrVelly(A[i - 2], A[i - 1], A[i + 1])) {
                removeCount++;
            } else {
                return -1;
            }
            // }

            // }
            i++;
        }

        return removeCount;
    }

    public static boolean checkPickOrVelly(int previus, int current, int next) {
        if (previus > current && current < next) {
            return true;
        } else if (previus < current && current > next) {
            return true;
        } else {
            return false;
        }
    }
}
