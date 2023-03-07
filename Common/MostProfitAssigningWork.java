package Common;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * You have n jobs and m workers. You are given three arrays: difficulty,
 * profit, and worker where:
 * 
 * difficulty[i] and profit[i] are the difficulty and the profit of the ith job,
 * and
 * worker[j] is the ability of jth worker (i.e., the jth worker can only
 * complete a job with difficulty at most worker[j]).
 * Every worker can be assigned at most one job, but one job can be completed
 * multiple times.
 * 
 * For example, if three workers attempt the same job that pays $1, then the
 * total profit will be $3. If a worker cannot complete any job, their profit is
 * $0.
 * Return the maximum profit we can achieve after assigning the workers to the
 * jobs.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker =
 * [4,5,6,7]
 * Output: 100
 * Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get a
 * profit of [20,20,30,30] separately.
 * Example 2:
 * 
 * Input: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
 * Output: 0
 * 
 * https://leetcode.com/problems/most-profit-assigning-work/description/
 */
public class MostProfitAssigningWork {
    public static void main(String[] args) {
        int[][] difficulty = {{ 2, 4, 6, 8, 10 },{85,47,57}};
        int[][] profit = {{ 10, 20, 30, 40, 50 },{24,66,99}};
        int[][] worker = {{ 4, 5, 6, 7 },{40,25,25}};
        for(int i =0; i < difficulty.length; i++){
        System.out.println(solution1(difficulty[i], profit[i], worker[i]));
        }

    }

    public static int solution(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<int[]> dificultyProfit = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < difficulty.length; i++) {
            dificultyProfit.add(new int[] { difficulty[i], profit[i] });
        }
        PriorityQueue<int[]> wQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // IntStream.of(worker).forEach(e -> wQueue.add(e));

        for (int i = 0; i < worker.length; i++) {
            wQueue.add(new int[] { worker[i], i });
        }

        int[] profitArray = new int[worker.length];
        while (!wQueue.isEmpty() && !dificultyProfit.isEmpty()) {
            if (wQueue.peek()[0] < dificultyProfit.peek()[0]) {
                wQueue.poll();
            } else {
                int[] work = wQueue.poll();
                profitArray[work[1]] = Math.max(profitArray[work[1]], work[0]);
            }
        }
        System.out.println(Arrays.toString(profitArray));
        return IntStream.of(profitArray).reduce(0, Integer::sum);
    }

    public static int solution1(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<int[]> dificultyProfit = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < difficulty.length; i++) {
            dificultyProfit.offer(new int[] { difficulty[i], profit[i] });
        }
        PriorityQueue<int[]> wQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < worker.length; i++) {
            wQueue.offer(new int[] { worker[i], i });
        }
        PriorityQueue<int[]> dificultyProfitrunning = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int totalProfit = 0;
        while (!wQueue.isEmpty()) {
            while (!dificultyProfit.isEmpty() && (dificultyProfitrunning.isEmpty() ||  dificultyProfit.peek()[0] <= wQueue.peek()[0])) {
                dificultyProfitrunning.offer(dificultyProfit.poll());
            }

            if (wQueue.peek()[0] < dificultyProfitrunning.peek()[0]) {
                wQueue.poll();
            }
            else {
                wQueue.poll();
                totalProfit += dificultyProfitrunning.peek()[1];
            }
        }
        return totalProfit;
    }
}
