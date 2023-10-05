package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ6603_로또 {

    static int k;
    static int[] A;
    static int[] B;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            A = new int[k];
            B = new int[k];
            visited = new boolean[k];

            for (int i = 0; i < k; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < k; i++) {
                dfs(i, 0);
            }

            sb.append("\n");
        }

        System.out.println(sb);


    }

    static void dfs(int v, int depth) {
        visited[v] = true;
        B[depth] = A[v];

        if (depth == 5) {
            for (int i = 0; i < 6; i++) {
                sb.append(B[i]).append(" ");
            }

            sb.append("\n");
            visited[v] = false;
            return;
        }

        for (int i = v + 1; i < k; i++) {
            dfs(i, depth + 1);
        }

        visited[v] = false;
    }
}
