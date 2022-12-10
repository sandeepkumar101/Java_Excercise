package DynamicProgramming;

import java.util.Arrays;

/**
 * Problem Statement
 * Given two integer arrays to represent weights and profits of ‘N’ items,
 * we need to find a subset of these items which will give us maximum profit
 * such that their cumulative weight is not more than a given number ‘C’.
 * Write a function that returns the maximum profit.
 * Each item can only be selected once, which means either
 * we put an item in the knapsack or skip it.
 */
public class Knopsack {

    public static void main(String[] args) {
        Knopsack ks = new Knopsack();
        int[] profits = { 1, 6, 10, 16 };
        int[] weights = { 1, 2, 3, 5 };
        int capacity = 7;
        // System.out.println(ks.solveKnapstack(profits, weights, capacity));
        System.out.println(ks.solveKnapsack(profits, weights, capacity));
        // System.out.println(ks.solveKnapstacDp(profits, weights, capacity));
        // System.out.println(ks.solveKnapstacDp1(profits, weights, capacity));
    }

    public int solveKnapstack(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[weights.length][capacity + 1];
        return solveKnapstackRecursive(dp, profits, weights, capacity, 0);
    }

    public int solveKnapstackRecursive(Integer[][] dp, int[] profits, int[] weights, int capacity, int index) {
        if (capacity <= 0 || profits.length <= index) {
            return 0;
        }

        if (dp[index][capacity] != null) {
            return dp[index][capacity];
        }
        int profitWith = 0;
        if (weights[index] <= capacity) {
            profitWith = profits[index]
                    + solveKnapstackRecursive(dp, profits, weights, capacity - weights[index], index + 1);
        }

        int profitWithOut = solveKnapstackRecursive(dp, profits, weights, capacity, index + 1);

        dp[index][capacity] = Math.max(profitWith, profitWithOut);

        return dp[index][capacity];
    }

    public int solveKnapstacDp(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[profits.length][capacity + 1];
        for (int[] ary : dp) {
            Arrays.fill(ary, 0, 1, 0);
        }

        for (int c = 1; c < capacity; c++) {
            if (weights[0] < capacity) {
                dp[0][c] = profits[0];
            }
        }
        /*
         * [0, 1, 1, 1, 1, 1, 1, 0]
         * [0, 0, 0, 0, 0, 0, 0, 0]
         * [0, 0, 0, 0, 0, 0, 0, 0]
         * [0, 0, 0, 0, 0, 0, 0, 0]
         */
        Print.print2D(dp);
        System.out.println("");
        for (int i = 1; i < profits.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0, profit2 = 0;

                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                }

                profit2 = dp[i - 1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }
        }
        Print.print2D(dp);
        printSelectedElement(dp, profits, weights, capacity);
        return dp[profits.length - 1][capacity];
    }

    public int solveKnapstacDp1(int[] profits, int[] weights, int capacity) {
        int[] dp = new int[capacity + 1];
        Arrays.fill(dp, 0);
        dp[1] = profits[0];
        int remainingCapacity = capacity;
        for (int i = 1; i < profits.length; i++) {
            for (int c = weights[i]; c <= capacity; c++) {
                int profit1 = 0, profit2 = 0;

                if (weights[i] <= remainingCapacity) {
                    profit1 = profits[i] + dp[remainingCapacity - weights[i - 1]];
                }

                profit2 = dp[c];
                dp[c] = Math.max(profit1, profit2);
            }
            remainingCapacity -= weights[i];
            System.out.println(Arrays.toString(dp));
        }
        // print2D(dp);
        // printSelectedElement(dp, profits, weights, capacity);
        return dp[capacity];
    }

    public static void printSelectedElement(int[][] dp, int[] profits, int[] weights, int capacity) {
        int totalProfit = dp[weights.length - 1][capacity];
        for (int i = weights.length - 1; i > 0; i--) {
            if (totalProfit != dp[i - 1][capacity]) {
                System.out.print(" " + weights[i]);
                capacity -= weights[i];
                totalProfit -= profits[i];
            }
        }
        if (totalProfit > 0) {
            System.out.print(" " + profits[0]);
        }
        System.out.println(" ");
    }

    /**
     * W P
     * 1 1  [0, 0, 0, 0, 0, 0, 0, 0]
     * 2 6  [0, 0, 0, 0, 0, 0, 0, 0]
     * 3 10 [0, 0, 0, 0, 0, 0, 0, 0]
     * 5 16 [0, 0, 0, 0, 0, 0, 0, 0]
     * 
     * @param profits
     * @param weights
     * @param capacity
     * @return
     */
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[profits.length][capacity + 1];
        for (int i = 0; i < profits.length; i++) {
            dp[i][0] = 0;
        }
        for (int c = 0; c < capacity; c++) {
            if (weights[0] <= c)
                dp[0][c] = profits[0];
            else
                dp[0][c] = 0;
        }
        System.out.println(Arrays.deepToString(dp));
        for (int i = 1; i < profits.length; i++) {
            for (int c = 0; c < capacity + 1; c++) {
                int profit1 = 0;
                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                }
                int profit2 = dp[i - 1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }
            System.out.println(Arrays.deepToString(dp));
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[profits.length - 1][capacity];
    }
}