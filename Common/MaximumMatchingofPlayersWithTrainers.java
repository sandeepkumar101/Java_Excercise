package common;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * 2410. Maximum Matching of Players With Trainers
 * Medium
 * 288
 * 9
 * Companies
 * You are given a 0-indexed integer array players, where players[i] represents
 * the ability of the ith player. You are also given a 0-indexed integer array
 * trainers, where trainers[j] represents the training capacity of the jth
 * trainer.
 * 
 * The ith player can match with the jth trainer if the player's ability is less
 * than or equal to the trainer's training capacity. Additionally, the ith
 * player can be matched with at most one trainer, and the jth trainer can be
 * matched with at most one player.
 * 
 * Return the maximum number of matchings between players and trainers that
 * satisfy these conditions.
 * https://leetcode.com/problems/maximum-matching-of-players-with-trainers/description/
 */
public class MaximumMatchingofPlayersWithTrainers {
    public static void main(String[] args) {
        int[][] players = {{ 4, 7, 9 },{1,1,1}};
        int[][] trainers = {{ 8, 2, 5, 8 },{10}};
        for(int  i =0; i<players.length;i++)
        {
            System.out.println(solution(players[i], trainers[i]));
        }
    }

    public static int solution(int[] players, int[] trainers) {
        PriorityQueue<Integer> playersQueue = new PriorityQueue<>((a, b) -> b - a);
        IntStream.of(players).forEach(p -> playersQueue.add(Integer.valueOf(p)));

        PriorityQueue<Integer> trainerQueue = new PriorityQueue<>(Collections.reverseOrder());
        IntStream.of(trainers).forEach(t -> trainerQueue.add(t));
        int match = 0;
        while (!playersQueue.isEmpty() && !trainerQueue.isEmpty()) {
            while (!playersQueue.isEmpty() && playersQueue.peek() > trainerQueue.peek()) {
                playersQueue.poll();
            }

            if (!playersQueue.isEmpty()
                    && !trainerQueue.isEmpty()
                    && playersQueue.peek() <= trainerQueue.peek()) {
                playersQueue.poll();
                trainerQueue.poll();
                match++;
            }
        }
        return match;
    }
}
