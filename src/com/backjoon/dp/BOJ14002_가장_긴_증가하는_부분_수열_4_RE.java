package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ14002_가장_긴_증가하는_부분_수열_4_RE {

    static int[] A;
    static int[] D;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        D = new int[N];
        parents = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            D[i] = 1;
            parents[i] = i;

            for (int j = i - 1; j >= 0; j--) {
                if (A[i] > A[j]) {
                    if (D[j] + 1 > D[i]) {
                        parents[i] = j;
                    }
                    D[i] = Math.max(D[i], D[j] + 1);

                }
            }
        }

        int max = 0;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (max < D[i]) {
                max = D[i];
                idx = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        dfs(idx, sb);

        sb.insert(0, "\n").insert(0, max);

        System.out.println(sb);
    }

    static void dfs(int v, StringBuilder sb) {
        sb.insert(0, " ").insert(0, A[v]);
        if (v == parents[v]) return;

        dfs(parents[v], sb);
    }
}
