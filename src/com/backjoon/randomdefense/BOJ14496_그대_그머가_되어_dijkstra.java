package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ14496_그대_그머가_되어_dijkstra {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        D = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        Arrays.fill(D, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            A[start].add(end);
            A[end].add(start);
        }

        int bfs = bfs(a, b);

        if (a != b && bfs == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(D[b]);

    }

    static int bfs(int a, int b) {
        PriorityQueue<BOJ14496_그대_그머가_되어.Node> queue = new PriorityQueue<>();
        queue.add(new BOJ14496_그대_그머가_되어.Node(a, 0));
        D[a] = 0;

        int result = 0;

        while (!queue.isEmpty()) {
            BOJ14496_그대_그머가_되어.Node poll = queue.poll();

            for (int i : A[poll.target]) {

                if (visited[i]) continue;
                visited[i] = true;

                if (D[i] > D[poll.target] + 1) {
                    D[i] = D[poll.target] + 1;
                    queue.add(new BOJ14496_그대_그머가_되어.Node(i, D[poll.target] + 1));
                }
            }
        }

        return result;
    }

    static class Node implements Comparable<BOJ14496_그대_그머가_되어.Node>{
        public int target;
        public int depth;

        public Node(int target, int depth) {
            this.target = target;
            this.depth = depth;
        }


        @Override
        public int compareTo(BOJ14496_그대_그머가_되어.Node o) {
            return Integer.compare(this.depth, o.depth);
        }
    }
}
