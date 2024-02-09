package com.backjoon.tree;

import java.io.*;
import java.util.*;

public class BOJ11725_트리의_부모_찾기 {

    static ArrayList<Integer>[] A;
    static int N;
    static boolean[] visited;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        parents = new int[N + 1];
        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }


        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int v) {
        visited[v] = true;

        for (int next : A[v]) {
            if (visited[next]) continue;

            parents[next] = v;
            dfs(next);
        }
    }
}
