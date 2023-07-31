package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon13023_친구_관계_파악하기 {

    static ArrayList<Integer>[] friends;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        // 깊이 5인것만 찾으면됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        friends = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends[a].add(b);
            friends[b].add(a);
        }

        flag = false;

        for (int i = 0; i < visited.length; i++) {
            dfs(i, 1);
            visited = new boolean[N];
        }

        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    static void dfs(int num, int depth) {
        if (depth == 4 || flag) {
            flag = true;
            return;
        }

        visited[num] = true;

        for (int i : friends[num]) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }

    }
}
