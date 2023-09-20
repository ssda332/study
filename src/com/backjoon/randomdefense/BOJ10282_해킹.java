package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ10282_해킹 {

    static ArrayList<Node>[] A;
    static boolean[] visited;
    static int[] D;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        //0911
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호

            A = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            D = new int[n + 1];

            for (int j = 1; j <= n; j++) {
                A[j] = new ArrayList<>();
            }

            for (int j = 1; j <= d; j++) {
                st = new StringTokenizer(br.readLine());
                int end = Integer.parseInt(st.nextToken());
                int start = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                Node node = new Node(end, time);
                A[start].add(node);
            }

            Arrays.fill(D, Integer.MAX_VALUE);
            bfs(c);

            int cnt = 0;
            int val = 0;

            for (int j = 1; j < D.length; j++) {
                if (D[j] < Integer.MAX_VALUE) {
                    cnt++;
                }

                if (D[j] > val && D[j] != Integer.MAX_VALUE) {
                    val = D[j];
                }
            }

            sb.append(cnt).append(" ").append(val).append("\n");

        }
        System.out.println(sb);
    }

    static void bfs(int c) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.time - o2.time;
            }
        });
        queue.add(new Node(c, 0));
        D[c] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (visited[poll.target]) continue;
            visited[poll.target] = true;

            for (Node node : A[poll.target]) {
                if (D[node.target] > D[poll.target] + node.time) {
                    D[node.target] = D[poll.target] + node.time;
                    queue.add(new Node(node.target, D[node.target]));
                }
            }

        }
    }

    static class Node {
        public int target;
        public int time;

        public Node(int target, int time) {
            this.target = target;
            this.time = time;
        }
    }
}
