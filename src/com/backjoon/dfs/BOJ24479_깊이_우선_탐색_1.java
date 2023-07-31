package com.backjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ24479_깊이_우선_탐색_1 {

    static ArrayList<Integer>[] A;
    static int[] visited;
    static StringBuilder sb = new StringBuilder();
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(A[i], Collections.reverseOrder());
        }


        visited[R]++;
        DFS(R);

        for (int i = 1; i < N + 1; i++) {
            System.out.println(visited[i]);
        }
    }

    static void DFS(int v) {
        for (int i : A[v]) {
            if (visited[i] == 0) {
                visited[i] = ++cnt;
                DFS(i);
            }
        }

    }
}
