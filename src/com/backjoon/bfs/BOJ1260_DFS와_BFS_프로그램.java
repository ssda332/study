package com.backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1260_DFS와_BFS_프로그램 {

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        DFS(R);
        visited = new boolean[N + 1];
        sb.append("\n");
        BFS(R);

        System.out.println(sb);
    }

    static void DFS(int n) {
        if (visited[n]) {
            return;
        }

        visited[n] = true;
        sb.append(n + " ");
        for (int i : A[n]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    static void BFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            sb.append(poll + " ");

            for (int i : A[poll]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
