package com.backjoon.dijkstra;

import java.io.*;
import java.util.*;

public class BOJ17835_면접보는_승범이네 {

    static int N;
    static int M;
    static int K;
    static ArrayList<Node>[] A;
    static long[] D;
    static boolean[] visited;
    static PriorityQueue<Node> queue = new PriorityQueue<>();

    static class Node implements Comparable<Node>{
        int target;
        long length;

        public Node(int target, long length) {
            this.target = target;
            this.length = length;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.length, o.length);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        D = new long[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            A[V].add(new Node(U, C));
        }

        Arrays.fill(D, Long.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(st.nextToken());
            queue.add(new Node(num, 0));
            D[num] = 0;
        }

        dijkstra();

        long max = 0;
        long maxVal = 0;

        for (int i = 1; i <= N; i++) {
            if (D[i] > maxVal) {
                maxVal = D[i];
                max = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(maxVal);
        System.out.println(sb);
    }

    static void dijkstra() {

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int cur = poll.target;

            if (visited[cur]) continue;
            visited[cur] = true;

            for (Node next : A[cur]) {
                int target = next.target;
                long length = next.length;

                if (D[target] > D[cur] + length) {
                    D[target] = D[cur] + length;
                    queue.add(new Node(target, D[target]));
                }
            }
        }
    }
}
