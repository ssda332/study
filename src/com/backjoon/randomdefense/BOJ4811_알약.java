package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ4811_알약 {

    static long[][] DP = new long[31][31];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        StringBuilder sb = new StringBuilder();

        do {
            N = Integer.parseInt(br.readLine());
            if (N == 0 ) break;
            long eat = eat(N, 0);
            sb.append(eat).append("\n");

        } while (N != 0);

        System.out.println(sb);

    }

    static long eat(int W, int H) {
        if (DP[W][H] != 0) return DP[W][H];

        if (W > 0) {
            // 반개 or 한개
            if (H > 0) DP[W][H] = eat(W, H - 1);
            DP[W][H] += eat(W - 1, H + 1);
        } else {
            return 1;
        }

        return DP[W][H];
    }
}
