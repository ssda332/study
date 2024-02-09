package com.backjoon.tree;

import java.io.*;
import java.util.*;

public class BOJ4803_트리 {

    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int cnt;
    static int cnt2 = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        File file = new File("C:/Users/input.txt");
//        BufferedReader br = new BufferedReader(new FileReader(file));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;
            if (M == 0) {
                cnt = N;
                write();
                continue;
            }
            A = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            cnt = 0;

            for (int i = 1; i <= N; i++) {
                A[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                A[start].add(end);
                A[end].add(start);
            }

            for (int i = 1; i <= N; i++) {
                if (visited[i]) continue;
                if (dfs(i, 0)) cnt++;
            }

            write();

        }

        System.out.println(sb);
    }

    static void write() {
        if (cnt == 0) {
            sb.append("Case ").append(cnt2).append(": ").append("No trees.").append("\n");
        } else if (cnt == 1) {
            sb.append("Case ").append(cnt2).append(": ").append("There is one tree.").append("\n");
        } else {
            sb.append("Case ").append(cnt2).append(": ").append("A forest of ").append(cnt).append(" trees.").append("\n");
        }

        cnt2++;
    }

    static boolean dfs(int v, int pre) {
        visited[v] = true;

        for (int next : A[v]) {
            if (visited[next]) {
                if (next != pre) return false;
                continue;
            }

            if (!dfs(next, v)) return false;
        }

        return true;
    }
}
