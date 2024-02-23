package com.algorithm.leetcode;

import java.io.*;

public class Leetcode_daily_997 {
    public static void main(String[] args) throws IOException {
        int[][] trust = {{1, 2}};
        int n = 2;

        int judge = findJudge(n, trust);
        System.out.println(judge);
    }

    static int findJudge(int n, int[][] trust) {
        int[][] isTrust = new int[n + 1][2];

        for (int i = 0; i < trust.length; i++) {
            int s = trust[i][0];
            int e = trust[i][1];

            isTrust[s][0]++;
            isTrust[e][1]++;
        }

        for (int i = 1; i <= n; i++) {
            if (isTrust[i][0] == 0 && isTrust[i][1] == n - 1) return i;
        }


        return -1;
    }
}
