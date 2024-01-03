package com.backjoon.dijkstra;

import java.io.*;
import java.util.*;

public class BOJ1916_최소비용_구하기 {

    static class Bus implements Comparable<Bus>{
        int target;
        int price;

        public Bus(int target, int price) {
            this.target = target;
            this.price = price;
        }

        @Override
        public int compareTo(Bus o) {
            return Integer.compare(this.price, o.price);
        }
    }

    static int N;
    static int M;
    static ArrayList<Bus>[] A;
    static boolean[] visited;
    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        D = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
            D[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            A[start].add(new Bus(end, price));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        dijkstra(X);

        System.out.println(D[Y]);


    }

    static void dijkstra(int start) {
        PriorityQueue<Bus> queue = new PriorityQueue<>();
        queue.add(new Bus(start, 0));
        D[start] = 0;

        while (!queue.isEmpty()) {
            Bus poll = queue.poll();
            int target = poll.target;

            if (visited[target]) continue;
            visited[target] = true;

            for (Bus bus : A[target]) {
                if (D[bus.target] > D[target] + bus.price) {
                    D[bus.target] = D[target] + bus.price;
                    queue.add(new Bus(bus.target, D[bus.target]));
                }
            }
        }
    }
}
