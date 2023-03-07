package Common;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * You have n tasks and m workers. Each task has a strength requirement stored
 * in a 0-indexed integer array tasks, with the ith task requiring tasks[i]
 * strength to complete. The strength of each worker is stored in a 0-indexed
 * integer array workers, with the jth worker having workers[j] strength. Each
 * worker can only be assigned to a single task and must have a strength greater
 * than or equal to the task's strength requirement (i.e., workers[j] >=
 * tasks[i]).
 * 
 * Additionally, you have pills magical pills that will increase a worker's
 * strength by strength. You can decide which workers receive the magical pills,
 * however, you may only give each worker at most one magical pill.
 * 
 * Given the 0-indexed integer arrays tasks and workers and the integers pills
 * and strength, return the maximum number of tasks that can be completed.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: tasks = [3,2,1], workers = [0,3,3], pills = 1, strength = 1
 * Output: 3
 * Explanation:
 * We can assign the magical pill and tasks as follows:
 * - Give the magical pill to worker 0.
 * - Assign worker 0 to task 2 (0 + 1 >= 1)
 * - Assign worker 1 to task 1 (3 >= 2)
 * - Assign worker 2 to task 0 (3 >= 3)
 * Example 2:
 * 
 * Input: tasks = [5,4], workers = [0,0,0], pills = 1, strength = 5
 * Output: 1
 * Explanation:
 * We can assign the magical pill and tasks as follows:
 * - Give the magical pill to worker 0.
 * - Assign worker 0 to task 0 (0 + 5 >= 5)
 * Example 3:
 * 
 * Input: tasks = [10,15,30], workers = [0,10,10,10,10], pills = 3, strength =
 * 10
 * Output: 2
 * Explanation:
 * We can assign the magical pills and tasks as follows:
 * - Give the magical pill to worker 0 and worker 1.
 * - Assign worker 0 to task 0 (0 + 10 >= 10)
 * - Assign worker 1 to task 1 (10 + 10 >= 15)
 * The last pill is not given because it will not make any worker strong enough
 * for the last task.
 * https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/description/
 * 
 */
public class MaximumNumberofTasksYouCanAssign {
    public static void main(String[] args) {
        int[][] tasks = { { 5, 9, 8, 5, 9 }, { 3, 2, 1 }, { 5, 4 }, { 10, 15, 30 } };
        int[][] workers = { { 1, 6, 4, 2, 6 }, { 0, 3, 3 }, { 0, 0, 0 }, { 0, 10, 10, 10, 10 } };
        int[] pills = { 1, 1, 1, 3 };
        int[] strength = { 5, 1, 5, 10 };
        for (int i = 0; i < tasks.length; i++) {
            System.out.println(solution(tasks[i], workers[i], pills[i], strength[i]));
            //System.out.println(solution1(tasks[i], workers[i], pills[i], strength[i]));
        }
        ;

    }

    public static int solution(int[] tasks, int[] workers, int pills, int strength) {
        int maxtask = 0;
        PriorityQueue<Integer> workQueue = new PriorityQueue<>();
        IntStream.of(workers).forEach(workQueue::offer);
        PriorityQueue<Integer> taskQueue = new PriorityQueue<>();
        IntStream.of(tasks).forEach(taskQueue::offer);

        PriorityQueue<Integer> workQueueNotAssigned = new PriorityQueue<>();
        PriorityQueue<Integer> taskQueueSlidingWindow = new PriorityQueue<>(Collections.reverseOrder());
        //assign task to all worker they don't need pills
        while (!workQueue.isEmpty()) {
            while (!taskQueue.isEmpty() && workQueue.peek() >= taskQueue.peek()) {
                taskQueueSlidingWindow.offer(taskQueue.poll());
            }
            if (!taskQueueSlidingWindow.isEmpty() && workQueue.peek() >= taskQueueSlidingWindow.peek()) {
                maxtask++;
                taskQueueSlidingWindow.poll();
                workQueue.poll();
            } else {
                int i = workQueue.poll();
                workQueueNotAssigned.offer(i);
            }
        }
        if (!taskQueueSlidingWindow.isEmpty()) {
            taskQueueSlidingWindow.forEach(taskQueue::offer);
        }
        //assign task to all worker they can work with pills
        while (pills > 0 && !workQueueNotAssigned.isEmpty() && !taskQueue.isEmpty()) {
            while (!taskQueue.isEmpty() && workQueueNotAssigned.peek() + strength >= taskQueue.peek()) {
                taskQueueSlidingWindow.offer(taskQueue.poll());
            }
            if (!taskQueueSlidingWindow.isEmpty() && workQueueNotAssigned.peek() + strength >= taskQueueSlidingWindow.peek()) {
                maxtask++;
                taskQueueSlidingWindow.poll();
                pills--;
                workQueueNotAssigned.poll();
            } else {
                workQueueNotAssigned.poll();
            }

        }
        return maxtask;
    }

    public static int solution1(int[] tasks, int[] workers, int pills, int strength) {
        int maxtask = 0;
        PriorityQueue<Integer> workQueue = new PriorityQueue<>();
        IntStream.of(workers).forEach(workQueue::offer);
        PriorityQueue<Integer> taskQueue = new PriorityQueue<>();
        IntStream.of(tasks).forEach(taskQueue::offer);
        return recurcivePill(taskQueue, workQueue, pills, strength, 0, maxtask, 1);
    }

    public static int recurcivePill(PriorityQueue<Integer> taskQueue, PriorityQueue<Integer> workQueue, int pills,
            int strength, int recurvice, int maxtask, int maxPills) {
        if (workQueue.isEmpty()) {
            return maxtask;
        }
        PriorityQueue<Integer> workQueueNotAssigned = new PriorityQueue<>();
        PriorityQueue<Integer> taskQueueSlidingWindow = new PriorityQueue<>(Collections.reverseOrder());
        while (!workQueue.isEmpty()) {
            int pillStrength = pills == 0 ? 0 : recurvice * strength;
            while (!taskQueue.isEmpty()
                    && workQueue.peek() + pillStrength >= taskQueue.peek()) {
                taskQueueSlidingWindow.offer(taskQueue.poll());
            }
            if (!taskQueueSlidingWindow.isEmpty()
                    && workQueue.peek() + pillStrength >= taskQueueSlidingWindow.peek()) {
                maxtask++;
                pills = pills - recurvice;
                taskQueueSlidingWindow.poll();
                workQueue.poll();
            } else {
                int i = workQueue.poll();
                workQueueNotAssigned.offer(i);
            }
        }
        if (!taskQueueSlidingWindow.isEmpty()) {
            taskQueueSlidingWindow.forEach(taskQueue::offer);
        }

        if (pills == 0 || recurvice == maxPills) {
            return maxtask;
        }
        if (!taskQueueSlidingWindow.isEmpty()) {
            taskQueueSlidingWindow.forEach(taskQueue::offer);
        }
        return recurcivePill(taskQueue, workQueueNotAssigned, pills, strength, recurvice + 1, maxtask, maxPills);

    }
}
