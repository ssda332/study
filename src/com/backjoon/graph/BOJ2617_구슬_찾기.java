package com.backjoon.graph;

import java.io.*;
import java.util.*;

public class BOJ2617_구슬_찾기 {

    static int N;
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static ArrayList<Integer>[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        B = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            B[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            B[e].add(s);
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            int result1 = bfs(i, A);
            int result2 = bfs(i, B);

            int size = N / 2 + 1;
            if (result1 >= size || result2 >= size) answer++;
        }

        System.out.println(answer);
    }

    static int bfs(int n, ArrayList<Integer>[] list) {
        visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;
        int result = 0;

        while (!q.isEmpty()) {
            int poll = q.poll();

            for (int next : list[poll]) {
                if (visited[next]) continue;
                q.add(next);
                visited[next] = true;
                result++;
            }
        }

        return result;
    }
}
