package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5567_결혼식 {

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        A = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        bfs(1);

        System.out.println(cnt);

    }

    static void bfs(int v) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {v, 0});
        visited[v] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int depth = poll[1];

            if (depth < 2) {
                for (int i : A[poll[0]]) {
                    if (!visited[i]) {
                        cnt++;
                        visited[i] = true;
                        queue.add(new int[] {i, depth + 1});
                    }
                }
            }

        }

    }

    static void dfs(int v, int depth) {
        visited[v] = true;

        for (int i : A[v]) {
//            System.out.println("v : " + v + ", i : " + i + ", depth : " + depth);
            if (!visited[i] && depth < 2) {
                cnt++;
                dfs(i, depth + 1);
            }
        }
    }
}
