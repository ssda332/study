package com.backjoon.backtracking;

import java.io.*;
import java.util.*;

public class BOJ15665_N과_M_11 {

    static int N;
    static int M;
    static int[] A;
    static int[] B;
    static LinkedHashSet<String> answer = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N + 1];
        B = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        bfs(0, 0);

        answer.stream()
                .forEach(System.out::println);

    }

    static void bfs(int v, int depth) {
        B[depth] = A[v];

        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= depth; i++) {
                sb.append(B[i]).append(" ");
            }

            answer.add(sb.toString());
            return;
        }

        for (int i = 1; i <= N; i++) {
            bfs(i, depth + 1);
        }
    }
}
