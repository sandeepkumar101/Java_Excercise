package DynamicProgramming;

public class LCS {

    public int findLCSLength(String s1, String s2) {
       
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        int maxLcs = 0;
        for(int i = 1; i <= s1.length(); i++)
        {
            for(int j = 1; j <= s2.length(); j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLcs = Math.max(maxLcs, dp[i][j]);
                } 
            }
        }
        Print.print2D(dp);
        return maxLcs;
      }
    
      public static void main(String[] args) {
        LCS lcs = new LCS();
        System.out.println(lcs.findLCSLength("abdca", "cbda"));
        System.out.println(lcs.findLCSLength("passport", "ppsspt"));
      }
    
}
