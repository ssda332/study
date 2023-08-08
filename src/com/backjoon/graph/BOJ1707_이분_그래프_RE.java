package com.backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1707_이분_그래프_RE {

    static ArrayList<Integer>[] A;
    static int[] check; // 집합배열
    static boolean[] visited;
    static boolean IsEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            A = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            check = new int[N + 1];
            IsEven = true;

            for (int i = 1; i <= N; i++) {
                A[i] = new ArrayList<>();
            }

            for (int i = 1; i <= V; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                A[start].add(end);
                A[end].add(start);
            }

            for (int i = 1; i <= N; i++) {
                if (IsEven) {
                    dfs(i);
                }else {
                    break;
                }
            }

            if (IsEven) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    static void dfs(int v) {
        visited[v] = true;

        for (int i : A[v]) {
            if (!visited[i]) {
                // 에지 타서 탐색한 노드를 이전 노드와 다른 집합이라고 표시
                check[i] = (check[v] + 1) % 2;
                dfs(i);
            }else if (check[i] == check[v]) {
                IsEven = false;
            }

        }
    }

}
