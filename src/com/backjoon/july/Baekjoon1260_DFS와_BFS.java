package com.backjoon.july;

import java.io.*;
import java.util.*;

public class Baekjoon1260_DFS와_BFS {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
            arr[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);
        }

        dfs(K);
        bw.write("\n");
        visited = new boolean[N + 1];
        bfs(K);

        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int num) throws IOException {
        if (visited[num]) {
            return;
        }

        visited[num] = true;
        bw.write(num + " ");

        for (int i : arr[num]) {
            if (!visited[i]) {
                dfs(i);
            }
        }

    }

    static void bfs(int num) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;

        while (!queue.isEmpty()) {
            int now_Node = queue.poll();
            bw.write(now_Node + " ");

            for (int i : arr[now_Node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

    }
}
