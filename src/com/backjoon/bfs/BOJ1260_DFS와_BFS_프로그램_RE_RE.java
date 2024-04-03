package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ1260_DFS와_BFS_프로그램_RE_RE {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        dfs(start);
        visited = new boolean[N + 1];
        sb.append("\n");
        bfs(start);

        System.out.println(sb);
    }

    static void bfs(int start) {
//        PriorityQueue<Node> q = new PriorityQueue<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int poll = q.poll();
            writeAnswer(poll);

            for (int next : A[poll]) {
                if (visited[next]) continue;

                q.add(next);
                visited[next] = true;
            }
        }
    }

    static void dfs(int target) {
        if (visited[target]) return;
        writeAnswer(target);
        visited[target] = true;

        for (int next : A[target]) {
            dfs(next);
        }


    }

    static void writeAnswer(Integer n) {
        sb.append(n).append(" ");
    }
}
