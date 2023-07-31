package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1167_트리의_지름_구하기 {

    static ArrayList<Edge>[] A;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());

        A = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        distance = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            while (true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) {
                    break;
                }
                int value = Integer.parseInt(st.nextToken());
                A[idx].add(new Edge(e, value));
            }
        }

        bfs(1);
        int Max = 1;
        for (int i = 0; i < distance.length; i++) {
            if (distance[Max] < distance[i]) {
                Max = i;
            }
        }
        visited = new boolean[V + 1];
        distance = new int[V + 1];
        bfs(Max);
        Arrays.sort(distance);
        System.out.println(distance[V]);

    }

    public static void bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = true;

            for (Edge edge : A[now]) {
                if (!visited[edge.e]) {
                    queue.add(edge.e);
                    distance[edge.e] = distance[now] + edge.value;
                }
            }
        }
    }

    static class Edge {
        public int e;
        public int value;

        public Edge(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }
}
