package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ18429_근손실 {

    static int N;
    static int K;
    static int[] kits;
    static int count = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        kits = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1, 500);
        }

        System.out.println(count);
    }

    static void dfs(int v, int depth, int power) {
        visited[v] = true;
        power = power + kits[v] - K;
        if (power < 500) {
            visited[v] = false;
            return;
        }

        if (depth == N) {
            count++;
            visited[v] = false;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, depth + 1, power);
                visited[i] = false;
            }
        }

        visited[v] = false;

    }
}
