package com.backjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11724_연결요소의_개수_RE {

    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

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

        int result = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                result++;
                DFS(i);
            }
        }

        System.out.println(result);

    }

    static void DFS(int v) {
        if (visited[v]) {
            return;
        }

        visited[v] = true;

        for (int i : A[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}
