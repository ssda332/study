package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ2644_촌수계산 {

    static int N;
    static int A;
    static int B;
    static class Node {
        int target;
        int depth;

        public Node(int target, int depth) {
            this.target = target;
            this.depth = depth;
        }
    }
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);
        }

        int answer = bfs();
        System.out.println(answer);

    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(A, 0));
        visited[A] = true;

        int result = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.depth > result) {
                result = poll.depth;
            }

            if (poll.target == B) {
                return result;
            }

            for (int target : list[poll.target]) {
                if (visited[target]) continue;

                queue.add(new Node(target, poll.depth + 1));
                visited[target] = true;
            }
        }

        return -1;
    }
}
