package dynamicprogramming;

import java.util.Arrays;

public class Print {

    private Print(){}

    public static void print2D(int[][] dp) {
        // Loop through all rows
        System.out.println(" ");
        for (int[] row : dp)
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
        
        System.out.println(" ");
    }

    public static void print2D(Boolean[][] dp) {
        // Loop through all rows
        System.out.println(" ");
        for (Boolean[] row : dp)
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));

        System.out.println(" ");
    }
}
