public class Bank {
    public static void main(String[] args) {
        System.out.println(solution("BAABA", new int[] { 2, 4, 1, 1, 2 }));
    }

    /**
     * Calculate the maximum amount of money needed into account.
     * 
     * @param R
     * @param V
     * @return
     */

    public static int[] solution(String R, int[] V) {
        // write your code in Java SE 8

        // Initialize the debt to zero
        int aDebt = 0;
        int bDebt = 0;
        // Initialize the balance to zero  
        int aBalance = 0;
        int bBalance = 0;

        final String A = "A";

        for (int i = 0; i < V.length; i++) {
            // Check for Bank Name A recipient of the transaction
            if (R.charAt(i) == A.charAt(0)) {
                aBalance += V[i];
                // Amount to be needed into account
                int balance = bBalance - V[i];
                // Check for balance availabe or not
                if (balance >= 0) {
                    // amount deducted from balance of Bank B
                    bBalance -= V[i];
                } else {
                    // balance Amount set to Zero if borrowed money needed
                    bBalance = 0;
                    // Added to the debt of Bank B
                    bDebt = bDebt - balance;
                }

            } else {
                // Amount to be needed into account
                int balance = aBalance - V[i];
                bBalance += V[i];
                // Check for balance availabe or not
                if (balance >= 0) {
                    // amount deducted from balance of Bank A
                    aBalance -= V[i];
                } else {
                    // balance Amount set to Zero if borrowed money needed
                    aBalance = 0;
                    // Added to the debt of Bank A
                    aDebt = aDebt - balance;
                }
            }
        }
        return new int[] { aDebt, bDebt };
    }

}
