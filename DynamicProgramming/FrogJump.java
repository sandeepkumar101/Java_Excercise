package dynamicprogramming;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Problem: A small frog wants to get from position 0 to k (1 � k � 10000). 
//The frog can jump over any one of n fixed distances s0,s1,...,sn−1 (1 � si � k). 
//The goal is to count the number of different ways in which the frog can jump to position k. 
//To avoid overflow, it is sufficient to return the result modulo q, where q is a given number.
//We assume that two patterns of jumps are different if, in one pattern, the frog visits a position 
//which is not visited in the other pattern.

//Solution O(n · k): The task can be solved by using dynamic programming. 
//Let’s create an array dp consisting of k elements, such that dp[j] will be the number of ways in which the frog can jump to position j.
//return dp
//The time complexity is O(n · k) and the space complexity is O(k).
//We update consecutive cells of array dp. There is exactly one way for the frog to jump to position 0, so dp[0] = 1. 
//Next, consider some position j > 0.
//The number of ways in which the frog can jump to position j with a final jump of si is dp[j − si]. 
//Thus, the number of ways in which the frog can get to position j is increased by the number of ways of getting to position j − si, for every jump si.

//More precisely, dp[j] is increased by the value of dp[j − si] (for all si � j) modulo q.

//def
//frog(S, k, q):
//n = len(S) dp=[1]+[0]*k
//for j in xrange(1, k + 1):
//for i in xrange(n): if S[i] <= j:
//            dp[j] = (dp[j] + dp[j - S[i]]) % q;
//return dp[k]
//complexity is O(n·k)

public class FrogJump {
    public static void main(String[] args) {
        int[] S = { 1, 2, 3, 5 };
        //int[] S1 = {1, 10, 25, 50,100 };
        int[] S1 = { 1, 2, 3, 5 };
        //System.out.println(frog(S, 4, 4));
        System.out.println(coinChange(S1, 5, 4));
    }

    public static int frog(int[] S, int k, int q) {
        int n = S.length;
        if(k<S[0])
        {
            return 0;
        }
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int j = 1; j < k + 1; j++) {
            //System.out.println("j:"+j);
            for (int i = 0; i < n; i++) {           // 0 
                if (S[i] <= j) {                    // true
                    dp[j] = (dp[j] + dp[j - S[i]]); // 
                    //printArray(dp); 
                }
                
            }
            
        }
        printArray(dp); 
        return dp[k-1];
    }

    public static int coinChange(int[] S, int k, int q) {
        int n = S.length;
        if(k<S[0])
        {
            return 0;
        }
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 0);
        //Arrays.fill(dp,0,S[0]-1, 1);
        dp[S[0]-1] = 1;
        for (int j = S[0]; j < k + 1; j++) {
            System.out.println("j:"+j);
            for (int i = 0; i < n; i++) {           // 0 
                if (S[i] <= j) {                    // true
                    dp[j] = (dp[j] + dp[j - S[i]]); // 
                    printArray(dp); 
                }
                
            }
            
        }
        printArray(dp); 
        return dp[k-1];
    }

    public static void printArray(int[] array)
    {
        IntStream s = Arrays.stream(array);
        s.forEach(i -> System.out.print(i+","));
        System.out.println(" ");
    }
}
