package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ11060_점프_점프 {

    static int N;
    static int[] map;
    static boolean[] visited;
    static int answer = -1;
    static class Node {
        int val;
        int depth;

        public Node(int val, int depth) {
            this.val = val;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        bfs();
        System.out.println(answer);

    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.val == N - 1) {
                answer = poll.depth;
                return;
            }

            for (int i = 1; i <= map[poll.val]; i++) {
                int jump = poll.val + i;
                if (jump >= N) continue;
                if (visited[jump]) continue;

                queue.add(new Node(jump, poll.depth + 1));
                visited[jump] = true;
            }
        }
    }
}
