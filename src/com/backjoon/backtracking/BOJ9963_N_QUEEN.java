package com.backjoon.backtracking;

import java.util.*;

public class BOJ9963_N_QUEEN {

    static int N;
    static boolean[] isUsed1;
    static boolean[] isUsed2;
    static boolean[] isUsed3;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        isUsed1 = new boolean[N];
        isUsed2 = new boolean[N + N - 1];
        isUsed3 = new boolean[N + N - 1];

        dfs(0);

        System.out.println(count);
    }

    static void dfs(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isUsed1[i] || isUsed2[i + depth] || isUsed3[i - depth + N - 1]) continue;

            isUsed1[i] = true;
            isUsed2[i + depth] = true;
            isUsed3[i - depth + N - 1] = true;

            dfs(depth + 1);

            isUsed1[i] = false;
            isUsed2[i + depth] = false;
            isUsed3[i - depth + N - 1] = false;
        }



    }

}
