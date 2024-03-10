package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ9095_123_더하기_RE_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] D = new int[N + 1];
            D[1] = 1;
            if (N >= 2) D[2] = 2;
            if (N >= 3) D[3] = 4;

            for (int i = 4; i <= N; i++) {
                D[i] = D[i - 1] + D[i - 2] + D[i - 3];
            }

            sb.append(D[N]).append("\n");
        }

        System.out.println(sb);
    }
}
