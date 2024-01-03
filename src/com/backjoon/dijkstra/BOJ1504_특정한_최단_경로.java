package com.backjoon.dijkstra;

import java.io.*;
import java.util.*;

public class BOJ1504_특정한_최단_경로 {

    static int N;
    static int E;
    static ArrayList<Node>[] A;
    static boolean[] visited;
    static int[] D;
    static int v1;
    static int v2;

    static class Node implements Comparable<Node>{
        public int next;
        public int weight;

        public Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        D = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            A[a].add(new Node(b, c));
            A[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        clearArr();

        int result = Math.min(getResult(v1, v2), getResult(v2, v1));

        if (result == Integer.MAX_VALUE || result < 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

    static int getResult(int first, int second) {
        int path1 = dijkstra(1, first, 0);
        clearArr();
        int path2 = dijkstra(first, second, path1);
        clearArr();
        int result = dijkstra(second, N, path2);
        clearArr();

        return result;
    }

    static void clearArr() {
        Arrays.fill(D, Integer.MAX_VALUE);
        visited = new boolean[N + 1];
    }

    static int dijkstra(int start, int end, int weight) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, weight));
        D[start] = weight;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int next = poll.next;

            if (visited[next]) continue;
            visited[next] = true;

            for (Node node : A[next]) {
                if (D[node.next] > D[next] + node.weight) {
                    D[node.next] = D[next] + node.weight;
                    queue.add(new Node(node.next, D[node.next]));
                }
            }
        }

        return D[end];
    }
}
