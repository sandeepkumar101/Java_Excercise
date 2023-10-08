package common;

import java.util.*;
import java.io.*;

/**
 * Input: start[] = {900, 940, 950, 1100, 1500, 18:0} n
 * stop[] = {910, 1200, 1120, 1130, 1900, 2000}
 * nlog(n)
 * n^2
 * 
 * 
 **/
class OverLappingInterval {

  public static int maxCPU(int[] start, int[] stop) {

    if (start == null || stop == null) {
      throw new IllegalArgumentException("Not a valid arguments");
    }

    if (start.length != stop.length) {
      throw new IllegalArgumentException("Not a valid arguments");
    }

    // 2D Array to hold the intervals
    int intervals[][] = new int[start.length][2];

    // PriorityQueue to to have the min on top to compare
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

    // Populate the intervals to 2D array
    for (int i = 0; i < start.length; i++) {
      intervals[i][0] = start[i];
      intervals[i][1] = stop[i];
    }

    // Sort by ascending starting point
    Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

    // Hold the maxCPU counts at any point of time
    int maxCPU = 0;

    // Loop through the Array
    for (int i = 0; i < intervals.length; i++) {
      // Loop until the minHeap top element is less than next start time
      while (!minHeap.isEmpty() && minHeap.peek() < intervals[i][0]) {
        // remove the top element
        minHeap.poll();
      }
      // Regards less add the new stop time to the queue
      minHeap.add(intervals[i][1]);

      // Keep the max at any point of time
      maxCPU = Math.max(maxCPU, minHeap.size());

    }

    return maxCPU;

  }

  public static void main(String[] args) {

    int start[] = { 900, 940, 1500, 1800, 950, 1100 };
    int stop[] = { 910, 1200, 1900, 2000, 1120, 1130 };
    System.out.print("Max CPU :" + maxCPU(start, stop));
  }

}