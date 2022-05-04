package Common;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CoinChange {
    public static void main(String[] args) {
        int[] coin = { 1, 3, 4 };
        int[] change = change(coin, 10);
        Arrays.stream(change).forEach(t -> System.out.print(t + ","));
        System.out.println("");
        change = change1(coin, 10);
        Arrays.stream(change).forEach(t -> System.out.print(t + ","));
    }

    public static int[] change(int[] coin, int k) {
        int[] dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int n = coin.length;

        dp[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = coin[i - 1]; j < k + 1; j++) {
                dp[j] = Math.min(dp[j - coin[i - 1]] + 1, dp[j]);
            }
        }

        return dp;
    }

    public static int[] change1(int[] coin, int k) {
        int[] dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int n = coin.length;

        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j < k + 1; j++) {
                // Set value if current position - coin value is less than old value
                dp[j] = Math.min(dp[j - coin[i]] + 1, dp[j]);
            }
        }

        return dp;
    }

}
