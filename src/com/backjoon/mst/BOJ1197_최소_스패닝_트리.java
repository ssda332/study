package com.backjoon.mst;

import java.io.*;
import java.util.*;

public class BOJ1197_최소_스패닝_트리 {

    static int N;
    static int M;
    static ArrayList<Node>[] A;
    static boolean[] visited;

    static class Node implements Comparable<Node>{
        int target;
        int cost;

        public Node(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            A[start].add(new Node(end, cost));
            A[end].add(new Node(start, cost));
        }

        long answer = prim();

        System.out.println(answer);

    }

    static long prim() {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(1, 0));

        long answer = 0;
        int count = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int target = poll.target;
            int cost = poll.cost;

            if (visited[target]) continue;

            answer += cost;
            count++;
            visited[target] = true;

            if (count == N) return answer;

            for (int i = 0; i < A[target].size(); i++) {
                Node next = A[target].get(i);
                if (visited[next.target]) continue;

                queue.add(next);
            }
        }

        return answer;
    }
}
