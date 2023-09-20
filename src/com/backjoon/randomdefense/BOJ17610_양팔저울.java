package com.backjoon.randomdefense;

import java.io.*;
        import java.util.*;

public class BOJ17610_양팔저울 {

    static int[] G;
    static int sum;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        G = new int[k];
        sum = 0;

        for (int i = 0; i < k; i++) {
            G[i] = Integer.parseInt(st.nextToken());
            sum += G[i];

        }

        visited = new boolean[sum + 1];

        dfs(0, 0);
        int answer = 0;
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) answer++;
        }

        System.out.println(answer);
        

    }

    static void dfs(int n, int depth) {
        if (depth < G.length) {
            dfs(n + G[depth], depth + 1);
            dfs(n - G[depth], depth + 1);
            dfs(n, depth + 1);
        }

        if (n > 0 && depth == G.length) visited[n] = true;
    }



}
