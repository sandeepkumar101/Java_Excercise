import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals, and
 * return an array of the non-overlapping intervals that cover all the intervals
 * in the input.
 * 
 * [1, 3], [2, 6], [5, 10], [15, 18]
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] list = { { 1, 3 }, { 2, 6 }, { 5, 10 }, { 15, 18 } };
        System.out.println(mergeArrayInteral(list));
    }

    public static int[][] mergeArrayInteral(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) // 1. i=0 , i = 3 , i=4
        {
            int currentendi = i; // currentendi = 0 , 3
            while (i + 1 < intervals.length && intervals[i][1] > intervals[i + 1][0]) // i=0 3>2, i=1 6>5, i = 2 ,
            {
                i++; // 1, 2

            }
            result.add(new int[] { intervals[currentendi][0], intervals[i][1] }); // [1,10],[15,18]

        }
        int[] intArray = new int[result.size()];
        return result.toArray(intArray);

    }

}