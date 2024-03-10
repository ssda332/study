package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ1325_효율적인_해킹_RE {

    static int N;
    static int M;
    static ArrayList<Integer>[] A;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        count = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            count[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int end = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            A[start].add(end);
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            if (count[i] == -1) {
                max = Math.max(dfs(i), max);
            } else {
                max = Math.max(count[i], max);
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (max == count[i]) sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    static int dfs(int v) {
        count[v] = 0;

        for (int next : A[v]) {
            if (count[next] == -1) {
                count[v]++;
                count[v] += dfs(next);
            } else {
                count[v]++;
                count[v] += count[next];
            }
        }

        return count[v];
    }
}
