package com.algorithm.baaarkingdog.chapter1;

import java.io.*;
import java.util.*;

public class BOJ10819_차이를_최대로 {

    static int N;
    static int[] A;
    static boolean[] visited;
    static int[] idx;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        idx = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            idx[0] = i;
            dfs(0);
        }

        System.out.println(answer);
    }

    static int solve() {
        int result = 0;

        for (int i = 1; i < N; i++) {
            result += Math.abs(A[idx[i - 1]] - A[idx[i]]);
        }

        return result;
    }

    static void dfs(int depth) {
        if (depth == N) {
            int solve = solve();
            if (answer < solve) answer = solve;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            idx[depth] = i;

            dfs(depth + 1);

            visited[i] = false;
        }
    }
}
