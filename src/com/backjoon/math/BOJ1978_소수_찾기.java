package com.backjoon.math;

import java.io.*;
import java.util.*;

public class BOJ1978_소수_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int num = A[i];
            boolean[] visited = new boolean[num + 1];

            for (int j = 2; j <= num; i++) {
                for (int k = j; k <= num; k += j) {
                    if (visited[j]) continue;
                    visited[j] = true;
                }
            }
        }
    }
}
