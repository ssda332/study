package com.backjoon.dijkstra;

import java.io.*;
import java.util.*;

public class BOJ1753_최단경로 {

    static int V,E,K;
    static int[] D;
    static boolean[] visited;
    static ArrayList<Node>[] A;
    static PriorityQueue<Node> queue = new PriorityQueue<>();

    static class Node implements Comparable<Node>{
        public int target;
        public int weight;

        public Node(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        D = new int[V + 1];
        visited = new boolean[V + 1];
        A = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i <= V; i++) {
            D[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            A[s].add(new Node(e, w));
        }

        queue.add(new Node(K, 0));
        D[K] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int target = poll.target;

            if (visited[target]) continue;
            visited[target] = true;
            for (Node node : A[target]) {
                if (D[node.target] > D[target] + node.weight) {
                    D[node.target] = D[target] + node.weight;
                    queue.add(new Node(node.target, D[node.target]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                sb.append(D[i]).append("\n");
            } else {
                sb.append("INF").append("\n");
            }
        }

        System.out.println(sb);
    }
}
