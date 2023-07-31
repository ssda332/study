package com.backjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ13023_ABCDE {

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean result;

    public static void main(String[] args) throws IOException {
        // A - B - C - D - E 4
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N];
        visited = new boolean[N];
        result = false;

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 1);
//            visited = new boolean[N];
            if (result) break;
        }

        if (result) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }

    static void DFS(int n, int d) {
        if (d == 5 || result) {
            result = true;
            return;
        }

        visited[n] = true;

        for (int i : A[n]) {
            if (!visited[n]) {
                DFS(i, d + 1);
            }
        }

        visited[n] = false;
    }
}
