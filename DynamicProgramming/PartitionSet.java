package DynamicProgramming;

import java.util.Arrays;

//
public class PartitionSet {
    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = { 1, 1, 3, 4, 7 };
        System.out.println(canPartition(num));
        System.out.println(canPartitionDp(num));
    }

    static boolean canPartition(int[] num) {
        // TODO: Write - Your - Code
        int sum = 0;
        for (int i = 0; i < num.length; i++)
            sum += num[i];

        // if 'sum' is a an odd number, we can't have two subsets with equal sum
        if (sum % 2 != 0)
            return false;

        Boolean[][] dp = new Boolean[num.length][sum % 2 + 1];
        return canPartitionRecursive(num, dp, 0, sum % 2);
    }

    static boolean canPartitionRecursive(int[] num, Boolean[][] dp, int index, int sum) {
        // TODO: Write - Your - Code
        if (index >= num.length)
            return false;
        if (sum == 0)
            return true;
        if (dp[index][sum])
            return true;
        if (sum >= num[index]) {
            if (canPartitionRecursive(num, dp, index + 1, sum - num[index])) {
                dp[index][sum] = true;
                return true;
            }
        }
        dp[index][sum] = canPartitionRecursive(num, dp, index + 1, sum);
        return dp[index][sum];

    }

    static boolean canPartitionDp(int[] num) {
        // TODO: Write - Your - Code
        int sum = 0;
        for (int i = 0; i < num.length; i++)
            sum += num[i];

        // if 'sum' is a an odd number, we can't have two subsets with equal sum
        if (sum % 2 != 0)
            return false;

        sum /= 2;
        Boolean[][] dp = new Boolean[num.length][sum + 1];
        for (Boolean[] ba : dp) {
            Arrays.fill(ba, 0, 1, true);
        }
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = num[0] == i;
        }

        for (int i = 1; i < num.length; i++) {
            for (int s = 1; s <= sum; s++) {
                if (num[i] <= s) {
                    dp[i][s] = dp[i - 1][s - num[i]];
                } else {
                    dp[i][s] = dp[i - 1][s];
                }

            }
        }
        print2D(dp);
        return dp[num.length - 1][sum];
    }

    public static void print2D(Boolean mat[][]) {
        // Loop through all rows
        for (Boolean[] row : mat)
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }
}
