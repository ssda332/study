package com.backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1707_이분_그래프 {

    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean IsEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 노드끼리 서로 인접하지 않는 두 집합으로 그래프의 노드 나눔 = 이분 그래프
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            IsEven = true;
            for (int i = 1; i <= V; i++) {
                A[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) { // 인접 리스트로 그래프 저장
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                A[start].add(end);
                A[end].add(start);
            }

            for (int i = 1; i <= V; i++) {
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
                // 인접한 노드는 같은 집합이 아니므로 이전 노드와 다른 집합으로 처리하기
                check[i] = (check[v] + 1) % 2;
                dfs(i);
            }else if (check[v] == check[i]) {
                // 이미 방문한 노드가 현재 내 노드와 같은 집합이면 이분 그래프가 아님
                IsEven = false;
            }
        }

    }
}
