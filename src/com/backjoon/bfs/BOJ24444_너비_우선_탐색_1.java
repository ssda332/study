package com.backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ24444_너비_우선_탐색_1 {

    static ArrayList<Integer>[] A;
    static int[] visited;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new int[N + 1];

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
            Collections.sort(A[i], Collections.reverseOrder());
        }

        BFS(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }
    }

    static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = count;

        while (!queue.isEmpty()) {
            int new_Node = queue.poll();

            for (int i : A[new_Node]) {
                if (visited[i] == 0) {
                    count++;
                    visited[i] = count;
                    queue.add(i);
                }
            }
        }

    }
}
