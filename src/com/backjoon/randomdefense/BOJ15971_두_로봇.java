package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ15971_두_로봇 {

    static ArrayList<Node>[] A;
    static boolean[] visited;
    static int[] D;

    public static void main(String[] args) throws IOException {
        // 0915
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R1 = Integer.parseInt(st.nextToken());
        int R2 = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        D = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            D[i] = Integer.MAX_VALUE;
        }
        D[R1] = 0;

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            A[s].add(new Node(e, w));
            A[e].add(new Node(s, w));
        }

        dijkstr(R1, R2);
/*
        Arrays.stream(D)
                .forEach(System.out::println);*/
//        System.out.println(D[R2]);

    }

    static void dijkstr(int r1, int r2) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(r1, 0, 0));
        D[r1] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
//            System.out.println("target : " + poll.t + ", weight : " + poll.w + ", max : " + poll.max);
            int t = poll.t;

            if (visited[t]) continue;
            visited[t] = true;

            if (t == r2) {
                System.out.println(poll.w - poll.max);
            }

            for (Node node : A[t]) {
//                System.out.println("A[t] target : " + node.t + ", weight : " + node.w);
                int target = node.t;
                int weight = node.w;
                int max = node.w;

                if (D[target] > D[t] + weight) {
                    D[target] = D[t] + weight;
                    queue.add(new Node(target, D[target], Math.max(max, poll.max)));
                }
            }
        }

    }

    static class Node implements Comparable<Node>{
        public int t;
        public int w;
        public int max;

        public Node(int t, int w) {
            this.t = t;
            this.w = w;
        }

        public Node(int t, int w, int max) {
            this.t = t;
            this.w = w;
            this.max = max;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
