package Common;

import DynamicProgramming.Print;

public class FindIsland {

    public static void main(String[] args) {
        /*
         * int[][] grid = {{1,1,1,1,0},
         * {1,1,0,1,0},
         * {1,1,0,0,0},
         * {0,0,0,0,0}};
         */
        int[][] grid = { { 1, 1, 1, 1, 0 },
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 1, 0 },
                { 0, 0, 1, 0, 0 },
                { 1, 0, 0, 1, 1 }
        };
        FindIsland mClass = new FindIsland();
        // System.out.println(mClass.findIslands(grid));
        System.out.println(findIslands1(grid));
    }

    int findIslands(int[][] grid) {

        int numberOfisland = 0;

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == 1) {
                    // Find and mark the island counted by seting 1 to -1
                    recCallToFindisland(grid, x, y);
                    Print.print2D(grid);
                    numberOfisland++;
                }
            }
        }
        return numberOfisland;
    }

    // Set the Island all 1's to -1
    void recCallToFindisland(int[][] grid, int x, int y) {

        if (x < 0 || x >= grid.length || y < 0 || y >= grid.length || grid[x][y] == 0 || grid[x][y] == -1) {
            return;
        } else {
            // set visited 1 to -1
            grid[x][y] = -1;
            // Travel all 4 directons
            recCallToFindisland(grid, x - 1, y);
            recCallToFindisland(grid, x + 1, y);
            recCallToFindisland(grid, x, y - 1);
            recCallToFindisland(grid, x, y + 1);
        }

    }

    public static int findIslands1(int[][] grid) {
        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    markIsland(grid, i, j);
                    island++;
                }
            }
        }
        return island;
    }

    public static void markIsland(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] < 1) {
            return;
        } else {
            grid[x][y] = -1;
            markIsland(grid, x, y - 1);
            markIsland(grid, x, y + 1);
            markIsland(grid, x - 1, y);
            markIsland(grid, x + 1, y);
        }

    }

}
