package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ1260_DFS와_BFS_프로그램_RE {

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

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

        BFS(V);

        System.out.println(sb);
    }

    static void BFS(int v) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            if (!visited[poll]) {
                sb.append(poll).append(" ");
                visited[poll] = true;

                for (int i : A[poll]) {
                    queue.add(i);
                }
            }

        }
    }
}
