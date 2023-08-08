package com.backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1325_효율적인_해킹 {

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        // dfs = 10만개 재귀 = x 단방향으로 방문하는 노드수 체크

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n = 10000 m = 100000

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        ans = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            A[start].add(end);
        }

        for (int i = 1; i <= N; i++) {
            bfs(i);
            visited = new boolean[N + 1];
        }

        StringBuilder sb = new StringBuilder();
        int max = Arrays.stream(ans)
                .max()
                .getAsInt();

        for (int i = 1; i <= N; i++) {
            if (ans[i] == max) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);

    }

    static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            visited[poll] = true;

            for (int i : A[poll]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    ans[i]++;
                }
            }
        }
    }
}
