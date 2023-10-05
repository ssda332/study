package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ1238_파티 {

    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] A = new ArrayList[M + 1];
        ArrayList<Edge>[] B = new ArrayList[M + 1];
        visited = new boolean[N + 1];
        int[] go = new int[N + 1];
        int[] back = new int[N + 1];
        for (int i = 1; i <= M; i++) {
            A[i] = new ArrayList();
            B[i] = new ArrayList();
        }

        Arrays.fill(go, Integer.MAX_VALUE);
        Arrays.fill(back, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            A[start].add(new Edge(end, time));
            B[end].add(new Edge(start, time));
        }

        dijkstra(X, go, A);
        dijkstra(X, back, B);

        int max = 0;

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, go[i] + back[i]);
        }

        System.out.println(max);
    }

    static void dijkstra(int v, int[] D, ArrayList<Edge>[] edges) {
        visited = new boolean[N + 1];
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        D[v] = 0;
        visited[v] = true;
        queue.add(new Edge(v, 0));

        while (!queue.isEmpty()) {
            Edge poll = queue.poll();
            int start = poll.end;

            for (Edge edge : edges[start]) {
                int end = edge.end;

                if (D[end] > D[start] + edge.time) {
                    D[end] = D[start] + edge.time;
                    queue.add(new Edge(end, D[end]));
                    visited[end] = true;
                }
            }
        }
    }

    static class Edge implements Comparable<Edge>{
        public int end;
        public int time;

        public Edge(int end, int time) {
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.time, o.time);
        }
    }
}
