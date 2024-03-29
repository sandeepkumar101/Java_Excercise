package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You want to buy public transport tickets for some upcoming days. You know
 * exactly the days on which you will be traveling. There are three types of
 * ticket:
 * 
 * 1-day ticket, costs 2, valid for one day;
 * 7-day ticket, costs 7, valid for seven consecutive days (e.g. if the first
 * valid day is X, then the last valid day is X+6);
 * 30-day ticket, costs 25, valid for thirty consecutive days.
 * You want to pay as little as possible having valid tickets on your travelling
 * days.
 * 
 * You are given a sorted (in increasing order) array A of days when you will be
 * traveling. For example, given:
 * 
 * A[0] = 1
 * A[1] = 2
 * A[2] = 4
 * A[3] = 5
 * A[4] = 7
 * A[5] = 29
 * A[6] = 30
 * you can buy one 7-day ticket and two 1-day tickets. The two 1-day tickets
 * should be used on days 29 and 30.
 * The 7-day ticket should be used on the first seven days.
 * The total cost is 11 and there is no possible way of paying less.
 * 
 * <1>, <2>, 3, <4>, <5>, 6, <7>,
 * 8, 9, 10, 11, 12, 13, 14,
 * 15, 16, 17, 18, 19, 20, 21,
 * 22, 23, 24, 25, 26, 27, 28,
 * <29>, <30>
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A consisting of N integers that specifies days on which
 * you will be traveling, returns the minimum amount of money that you have to
 * spend on tickets.
 * 
 * For example, given the above data, the function should return 11, as
 * explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * M is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..M];
 * N is an integer within the range [1..M];
 * array A is sorted in increasing order;
 * the elements of A are all distinct.
 */
public class TransportTicket {
    public static void main(String[] args) {
        int[] days = { 1, 4, 6, 7, 8, 20 }, costs = { 2, 7, 15 };
        System.out.println(mincostTickets1(days, costs));
    }

    public static int mincostTickets(int[] days, int[] costs) {
        int[] durations = new int[] { 1, 7, 30 };
        int[] dp = new int[days.length + 1];
        List<Integer> list = new ArrayList<>();
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= days.length; i++) {
            for (int k = 0; k < 3; k++) {
                int next = i;
                while (next >= 1 && days[next - 1] > days[i - 1] - durations[k]) {
                    next--;
                }
                if (dp[i] > dp[next] + costs[k]) {
                    list.add(costs[k]);
                }
                dp[i] = Math.min(dp[i], dp[next] + costs[k]);

            }
        }
        System.out.println(list.toString());
        return dp[days.length];
    }

    public static int mincostTickets1(int[] days, int[] costs) {
        int n = days.length;
        int[] duration = { 1, 7, 30 };
        int[] dp = new int[n + 1];
        int[] dpTicket = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> tickets = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            // int[] minCost = new int[3];
            // int min = 0;
            for (int k = 0; k < costs.length; k++) {
                int next = i;
                while (next >= 1 && days[next - 1] > days[i - 1] - duration[k]) {
                    next--;
                }
                // minCost[k]=dp[next] + costs[k];
                dp[i] = Math.min(dp[i], dp[next] + costs[k]);
            }
            // list.add(Math.min(minCost[0], Math.min(minCost[1],minCost[2])));

        }

        dpTicket = ticketByday(dp, costs, dpTicket);
        System.out.println(list.toString());
        return dp[days.length];
    }

    public static int[] ticketByday(int[] daysCost, int[] costs, int[] dpTicket) {
        for (int i = daysCost.length - 1; i > 0; i--) {
            int totalCost = daysCost[i];
            for (int k = costs.length - 1; k >= 0; k--) {

                if (totalCost % costs[k] == 0) {
                    totalCost = costs[k];
                    /*
                     * dpTicket[i]=costs[k];
                     * int j = i;
                     * int sum = dpTicket[i];
                     * while(j>0 && sum>0)
                     * {
                     * sum -=dpTicket[j]-dpTicket[j-1];
                     * dpTicket[j]=0;
                     * j--;
                     * }
                     * dpTicket[j+1]=costs[k];
                     */
                    break;
                } else {
                    totalCost = totalCost % costs[k];
                }

            }
        }
        return dpTicket;
    }

}
