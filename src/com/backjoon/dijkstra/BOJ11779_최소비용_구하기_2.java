package com.backjoon.dijkstra;

import java.io.*;
import java.util.*;

public class BOJ11779_최소비용_구하기_2 {

    static ArrayList<Edge>[] A;
    static int[] D;
    static boolean[] visited;
    static int[] route;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        A = new ArrayList[n + 1];
        D = new int[n + 1];
        visited = new boolean[n + 1];
        route = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            A[i] = new ArrayList<>();
        }

        Arrays.fill(D, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            A[start].add(new Edge(end, price));
        }

        // 시작 출발
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        sb.append(D[end]).append("\n");
        ArrayList<Integer> routes = new ArrayList<>();
        routes.add(end);
        while (end != start) {
            end = route[end];
            routes.add(end);
        }

        sb.append(routes.size()).append("\n");
        for (int i = routes.size() - 1; i >= 0; i--) {
            sb.append(routes.get(i)).append(" ");
        }

        System.out.println(sb);


    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start, 0));
        D[start] = 0;

        while (!queue.isEmpty()) {
            Edge poll = queue.poll();

            if (visited[poll.target]) continue;
            visited[poll.target] = true;

            for (Edge edge : A[poll.target]) {
                if (D[edge.target] > D[poll.target] + edge.price) {
                    D[edge.target] = D[poll.target] + edge.price;
                    route[edge.target] = poll.target;
                    queue.add(new Edge(edge.target, D[poll.target] + edge.price));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge>{
        public int target;
        public int price;

        public Edge(int target, int price) {
            this.target = target;
            this.price = price;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.price, o.price);
        }
    }
}
