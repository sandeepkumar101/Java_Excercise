package DynamicProgramming;

import java.util.Arrays;

public class CountSubstrings {
    public static void main(String[] args) {
        String s = "abbaeae";

        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String str) {
        int[][] dp = new int[str.length()][str.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int count = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPal(str, i, j, dp) > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int isPal(String str, int i, int j, int[][] dp) {
        // Base and termination condition
        if (i > j)
            return 1;
        //If already excuted
        if (dp[i][j] != -1)
            return dp[i][j];
        //Is not match
        if (str.charAt(i) != str.charAt(j))
            return dp[i][j] = 0;
        // If match keep going
        return dp[i][j] = isPal(str, i + 1, j - 1, dp);

    }

}
