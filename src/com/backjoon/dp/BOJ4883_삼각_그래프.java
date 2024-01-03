package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ4883_삼각_그래프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int idx = 1;

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int[][] graph = new int[N][3];
            int[][] D = new int[N][3];

            // D[i][j] : i번째에 행의 j번째 열에 도달하였을 때 최소비용
            // D[i][0] = min(D[i - 1][0], D[i - 1][1])
            // D[i][1] = min(D[i - 1][0], D[i - 1][1], D[i - 1][2])
            // D[i][2] = min(D[i - 1][1], D[i - 1][2])

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 초기값
            D[1][0] = graph[0][1] + graph[1][0];
            D[1][1] = Math.min(Math.min(D[1][0] + graph[1][1], graph[0][1] + graph[1][1]), graph[0][1] + graph[0][2] + graph[1][1]);
            D[1][2] = Math.min(Math.min(D[1][1] + graph[1][2], graph[0][1] + graph[1][2]), graph[0][1] + graph[0][2] + graph[1][2]);

            if (N > 2) {
                for (int i = 2; i < N; i++) {
                    D[i][0] = Math.min(D[i - 1][0] + graph[i][0], D[i - 1][1] + graph[i][0]);
                    D[i][1] = Math.min(Math.min(Math.min(D[i - 1][0] + graph[i][1], D[i - 1][1] + graph[i][1]), D[i - 1][2] + graph[i][1]), D[i][0] + graph[i][1]);
                    D[i][2] = Math.min(Math.min(D[i - 1][1] + graph[i][2], D[i - 1][2] + graph[i][2]), D[i][1] + graph[i][2]);
                }
            }

            sb.append(idx).append(". ").append(D[N - 1][1]).append("\n");
            idx++;
        }

        System.out.println(sb);
    }
}
