package com.backjoon.dijkstra;

import java.io.*;
import java.util.*;

public class BOJ1753_최단경로_RE {

    static ArrayList<Node>[] A;
    static boolean[] visited;
    static int[] D;
    static class Node implements Comparable<Node>{
        int target;
        int length;

        public Node(int target, int length) {
            this.target = target;
            this.length = length;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.length, o.length);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());
        A = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        D = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<>();
            D[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            A[u].add(new Node(v, w));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (D[i] != Integer.MAX_VALUE) {
                sb.append(D[i]).append("\n");
            } else {
                sb.append("INF").append("\n");
            }
        }

        System.out.println(sb);

    }

    static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        D[start] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (visited[poll.target]) continue;
            visited[poll.target] = true;

            for (Node next : A[poll.target]) {
                if (visited[next.target]) continue;

                if (D[poll.target] + next.length < D[next.target]) {
                    D[next.target] = D[poll.target] + next.length;
                    queue.add(new Node(next.target, D[next.target]));
                }
            }
        }

    }
}
