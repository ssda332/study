package com.backjoon.graph;

import java.io.*;
import java.util.*;

public class BOJ6118_경로_찾기 {

    static int N;
    static int M;
    static int[] barn;
    static boolean[] visited;
    static ArrayList<Integer>[] A;

    static int ans = 1;
    static int ans_len = 0;
    static int ans_cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        barn = new int[N + 1];
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            A[start].add(end);
            A[end].add(start);
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        sb.append(ans).append(" ").append(ans_len).append(" ").append(ans_cnt);

        System.out.println(sb);

    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (ans_len < poll.depth) {
                ans = poll.position;
                ans_len = poll.depth;
                ans_cnt = 1;
            } else if (ans_len == poll.depth){
                if (ans > poll.position) ans = poll.position;
                ans_cnt++;
            }

            for (int next : A[poll.position]) {
                if (!visited[next]) {
                    queue.add(new Node(next, poll.depth + 1));
                    visited[next] = true;
                }
            }
        }
    }

    static class Node {
        public int position;
        public int depth;

        public Node(int position, int depth) {
            this.position = position;
            this.depth = depth;
        }
    }
}
