package com.backjoon.mst;

import java.io.*;
import java.util.*;

public class BOJ16398_행성_연결 {

    static int N;
    static ArrayList<Node>[] A;
    static PriorityQueue<Node> queue = new PriorityQueue<>();
    static boolean[] visited;
    static class Node implements Comparable<Node>{
        int target;
        int price;

        public Node(int target, int price) {
            this.target = target;
            this.price = price;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.price, o.price);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (j <= i) {
                    st.nextToken();
                } else {
                    int price = Integer.parseInt(st.nextToken());
                    A[i].add(new Node(j, price));
                    A[j].add(new Node(i, price));
                }
            }
        }

        long answer = prim();
        System.out.println(answer);
    }

    static long prim() {
        queue.add(new Node(1, 0));

        long answer = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (visited[poll.target]) continue;
            visited[poll.target] = true;
            answer += poll.price;

            for (Node next : A[poll.target]) {
                if (visited[next.target]) continue;
                queue.add(next);
            }

        }

        return answer;
    }
}
