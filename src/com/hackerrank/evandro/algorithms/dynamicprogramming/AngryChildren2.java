package com.hackerrank.evandro.algorithms.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*A solution to https://www.hackerrank.com/challenges/angry-children-2/problem challenge*/
public class AngryChildren2 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        long lowestUnfairness, lastUnfairness, lastSum;
        long[] bags = new long[n];

        for (int i = 0; i < bags.length; i++) {
            bags[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(bags);

        long results[] = calculateUnfairness(bags, 0, k);
        lastUnfairness = results[0];
        lastSum = results[1];

        lowestUnfairness = lastUnfairness;

        for (int i = k; i < bags.length; i++) {
            results = calculateUnfairness(lastUnfairness, lastSum, bags[i], bags[i - k], bags[i - k + 1], k);
            lastUnfairness = results[0];
            lastSum = results[1];
            if (lastUnfairness < lowestUnfairness) {
                lowestUnfairness = lastUnfairness;
            }
        }

        System.out.println(lowestUnfairness);
    }

    private static long[] calculateUnfairness(long[] bags, int start, int end) {
        long unfairness = 0;
        long sum = 0;
        int j = 0;
        for (int i = start; i < end; i++) {
            sum += bags[i];
            unfairness += j * bags[i];
            unfairness -= (end - start - 1 - j) * bags[i];
            j++;
        }
        return new long[]{unfairness, sum - bags[start]};
    }

    private static long[] calculateUnfairness(long lastUnfairness, long lastSum, long in, long out, long second, long k) {
        long unfairness = lastUnfairness + (k - 1) * out;
        unfairness -= lastSum;
        unfairness += ((k - 1) * in) - lastSum;
        lastSum -= second;
        lastSum += in;
        return new long[]{unfairness, lastSum};
    }
}
