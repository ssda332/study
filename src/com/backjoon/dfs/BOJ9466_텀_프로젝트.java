package com.backjoon.dfs;

import java.io.*;
import java.util.*;

public class BOJ9466_텀_프로젝트 {

    static int n;
    static int[] A;
    static boolean[] visited;
    static boolean[] cycled;
    static int answer = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = new int[n + 1];
            visited = new boolean[n + 1];
            cycled = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                dfs(i);
            }

            int result = n - answer;
            sb.append(result).append("\n");
            answer = 0;

        }

        System.out.println(sb);
    }

    static void dfs(int v) {
        visited[v] = true;
        int target = A[v];

        if (!visited[target]) {
            dfs(target);
        } else {
            if (!cycled[target]) {
                answer++;
                for (int i = target; i != v; i = A[i]) {
                    answer++;
                }
            }
        }

        cycled[v] = true;
    }
}
