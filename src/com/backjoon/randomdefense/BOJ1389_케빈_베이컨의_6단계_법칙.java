package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ1389_케빈_베이컨의_6단계_법칙 {

    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // 0924
        // bfs O(N * (N + M)) 510000 * 1000

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            A[start].add(end);
            A[end].add(start);
        }

        int min = Integer.MAX_VALUE;
        int val = 1;

        for (int i = 1; i <= N; i++) {
            int kevin = 0;
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    kevin += bfs(i, j);
//                    System.out.println("i : " + i + ", j : " + j + ", kevin : " + kevin);
                    visited = new boolean[N + 1];
                }
            }

            if (kevin < min) {
                min = kevin;
                val = i;
            }
        }

        System.out.println(val);
    }

    static int bfs(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            if (poll[0] == end) return poll[1];

            for (int i : A[poll[0]]) {
                if (!visited[i]) {
                    queue.add(new int[] {i, poll[1] + 1});
                    visited[i] = true;
                }
            }

        }

        return 0;
    }
}
