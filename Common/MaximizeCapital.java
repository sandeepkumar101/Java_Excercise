package common;

import java.util.*;

public class MaximizeCapital {
    public static void main(String[] args) {
        int[] c = { 1, 2, 1, 7, 2 };
        int[] k = { 2, 3, 3, 2, 4 };
        int[][] capitals = {
                { 1, 2, 2, 3 },
                { 1, 3, 4, 5, 6 },
                { 1, 2, 3, 4 },
                { 2, 7, 8, 10 },
                { 2, 3, 5, 6, 8, 12 }
        };
        int[][] profits = {
                { 2, 4, 6, 8 },
                { 1, 2, 3, 4, 5 },
                { 1, 3, 5, 7 },
                { 4, 8, 12, 14 },
                { 1, 2, 5, 6, 8, 9 }
        };
        for (int i = 0; i < k.length; i++) {

            System.out.println((i + 1) + ".\tGiven profits: " + Arrays.toString(profits[i]));
            System.out.print("  \tSelecting profits...");
            int selectProfit = maximumCapital(c[i], k[i], capitals[i], profits[i]);
            System.out.println(selectProfit);
        }
    }

    public static int maximumCapital(int c, int k, int[] capitals, int[] profits) {

        PriorityQueue<int[]> capitalminheap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> profitMaxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < capitals.length; i++) {
            capitalminheap.offer(new int[] { capitals[i], i });
        }
        int currentCapital = c;
        for (int i = 0; i < k; i++) {
            while (!capitalminheap.isEmpty() && capitalminheap.peek()[0] <= currentCapital) {
                int[] mincap = capitalminheap.poll();
                profitMaxHeap.offer(new int[] { profits[mincap[1]], mincap[1] });
            }
            if (profitMaxHeap.isEmpty()) {
                break;
            }

            currentCapital += profitMaxHeap.poll()[0];

        }
        // replace the dummy return with your code

        return currentCapital;
    }
}