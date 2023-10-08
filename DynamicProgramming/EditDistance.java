package dynamicprogramming;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        System.out.println(ed.findMinOperations("abdca", "cbda"));

    }

    public int findMinOperations(String s1, String s2) {
        if (s1 == s2)
            return 0;

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= s2.length(); i++) {
            dp[0][i] = i;
        }

        print2D(dp);
        for (int i1 = 1; i1 <= s1.length(); i1++) {
            for (int i2 = 1; i2 <= s2.length(); i2++) {
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
                    dp[i1][i2] = dp[i1 - 1][i2 - 1];
                } else {
                    dp[i1][i2] = 1 + Math.min(dp[i1][i2 - 1], Math.min(dp[i1 - 1][i2], dp[i1 - 1][i2 - 1]));
                }
                print2D(dp);
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void print2D(int mat[][]) {
        // Loop through all rows
        System.out.println(" ");
        for (int[] row : mat)
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }
}
