package com.divya.practice.leetcode.juneChallenge;

import java.util.Arrays;

public class TwoCityScheduling {

    public static void main(String[] args) {
        int[][] a = { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };
        System.out.println(twoCitySchedCost(a));
    }

    public static int twoCitySchedCost(int[][] costs) {
        int minCost = 0;

        Arrays.sort(costs, (cost1, cost2) -> (cost1[1] - cost1[0]) - (cost2[1] - cost2[0]));

        // for (int i = 0; i < costs.length; i++) {
        // System.out.println(costs[i][0] + "::" + costs[i][1]);
        // }

        int iter = 0;

        while (iter < costs.length) {
            if (iter < costs.length / 2)
                minCost += costs[iter][1];
            else
                minCost += costs[iter][0];
            iter++;
        }

        return minCost;
    }

}
