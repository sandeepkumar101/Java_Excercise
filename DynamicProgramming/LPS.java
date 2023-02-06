package DynamicProgramming;

class LPS {

    public int findLPSLength(String st) {
        int[][] dp = new int[st.length()][st.length()];

        for (int i = 0; i < st.length(); i++) {
            dp[i][i] = 1;
        }
        Print.print2D(dp);
        System.out.println(st.length());
        for (int i = st.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < st.length(); j++) {
                if (st.charAt(i ) == st.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                Print.print2D(dp);
            }
        }
        return dp[0][st.length() - 1];
    }

    public static void main(String[] args) {
        LPS lps = new LPS();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));
    }
}
