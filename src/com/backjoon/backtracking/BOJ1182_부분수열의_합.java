package com.backjoon.backtracking;

import java.io.*;
import java.util.*;

public class BOJ1182_부분수열의_합 {

    static int N;
    static int S;
    static int[] A;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        visited = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(count);

    }

    static void dfs(int v, int sum) {
        visited[v] = true;

        if (sum == S && v != 0) {
            count++;
        }

        for (int i = v + 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i, sum + A[i]);
            }
        }

        visited[v] = false;
    }
}
