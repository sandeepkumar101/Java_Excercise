package common;

import java.util.Arrays;

import dynamicprogramming.Print;

public class Sudoku {

    /**
     * [5 3 - - 7 - - - -]
     * 
     * [6 - - 1 9 5 - - -]
     * 
     * [- 9 8 - - - - 6 -]
     * 
     * [8 - - - 6 - - - 3]
     * 
     * [4 - - 8 - 3 - - 1]
     * 
     * [7 - - - 2 - - - 6]
     * 
     * [- 6 - - - - 2 8 -]
     * 
     * [- - - 4 1 9 - - 5]
     * 
     * [- - - - 8 - - 7 9]
     * 
     * //1-9
     * //1. each row no duplicate
     * //2. each column can no duplicate
     * //3. 9*9 = 9 * (3 * 3)
     * 
     */

    public static String Foo(String param) {
        return param;
    }

    public static void main(String[] args) {
        System.out.print(Foo("hello"));
        Sudoku sudoku = new Sudoku();
        int[][] grid = {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
        System.out.println(sudoku.checkSudoku(grid));
        Print.print2D(grid);
    }

    boolean checkSudoku(int[][] grid) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int[][] subGrid = new int[3][3];
                for (int k = 0; k < 3; k++) {
                    subGrid[k] = Arrays.copyOfRange(grid[(i * 3) + k], j * 3, (j + 1) * 3);
                }

                if (!(checkColumn(subGrid) && checkRow(subGrid)))
                    return false;

            }
        }
        return checkColumn(grid) && checkRow(grid);

    }

    boolean checkColumn(int[][] grid) {
        //
        System.out.println("Checking Column");
        int[] array = new int[10];
        // Arrays.fill(array,0);
        for (int i = 0; i < grid[0].length; i++) {
            Arrays.fill(array, 0);
            for (int j = 0; j < grid.length; j++) {
                if (array[grid[j][i]] > 0) {
                    System.out.println("Checking Row: False");
                    return false;
                }

                // Ignore Zeros
                if (grid[j][i] > 0)
                    array[grid[j][i]]++;
            }
        }
        System.out.println("Checking Column:True");
        return true;
    }

    // [5 3 - - 7 - - - -]
    // [0 0 0 0 0 0 0 0 0]
    boolean checkRow(int[][] grid) {
        System.out.println("Checking Row");
        int[] array = new int[10];

        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(array, 0);
            for (int j = 0; j < grid[i].length; j++) {
                if (array[grid[i][j]] > 0) {
                    System.out.println("Checking Row:False");
                    return false;
                }
                // Ignore Zeros
                if (grid[i][j] > 0)
                    array[grid[i][j]]++;
            }
        }
        System.out.println("Checking Row:True");
        return true;
    }

}
