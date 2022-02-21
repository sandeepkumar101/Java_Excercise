import java.util.*;
public class RemoveCoveredIntervals {
    public static void main(String[] args) {
        System.out.println(removeCoveredInterval(new int[][]{{1,4},{3,6},{3,7},{4,5}}));
    }
    public static int removeCoveredInterval(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        System.out.println(intervals);
        int count = 0, cur = 0;
        for(int interval[] : intervals){
            if(cur < interval[1]){
                cur = interval[1];
                count++;
            }
        }
        return count;
    }
}
