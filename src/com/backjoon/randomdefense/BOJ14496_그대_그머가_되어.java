package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ14496_그대_그머가_되어 {

    static ArrayList<Integer>[] A;
    static boolean[] visited;

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

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            A[start].add(end);
            A[end].add(start);
        }


        System.out.println(bfs(a, b));


    }

    static int bfs(int a, int b) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, 0));
        visited[a] = true;


        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.target == b) {
                return poll.depth;
            }

            for (int i : A[poll.target]) {

                if (!visited[i]) continue;
                visited[i] = true;

                queue.add(new Node(i, poll.target + 1));
            }
        }

        return -1;
    }

    static class Node {
        public int target;
        public int depth;

        public Node(int target, int depth) {
            this.target = target;
            this.depth = depth;
        }

    }
}