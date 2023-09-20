package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ15988_123_더하기_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        // D[i] = D[i - 3] + D[i - 2] + D[i - 1]
        long[] D = new long[1000001];
        D[1] = 1; D[2] = 2; D[3] = 4;

        for (int i = 4; i <= 1000000; i++) {
            D[i] = (D[i - 3] + D[i - 2] + D[i - 1]) % 1000000009;
        }


        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            if (N <= 3) {
                if (N == 1) sb.append(1).append("\n");
                if (N == 2) sb.append(2).append("\n");
                if (N == 3) sb.append(4).append("\n");
                continue;
            }

            sb.append(D[N]).append("\n");

        }

        System.out.println(sb);

    }
}
