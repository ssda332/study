package com.backjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long[] sum = new long[N];
        long[] combination = new long[M];
        long result = 0;

        sum[0] = Integer.parseInt(st.nextToken()) % M;

        for (int i = 1; i < N; i++) {
            sum[i] = (sum[i - 1] + Integer.parseInt(st.nextToken())) % M;
        }

        for (int i = 0; i < N; i++) {
            int num = (int) sum[i];
            if (num == 0) result++;
            combination[num]++;
        }

        for (int i = 0; i < M; i++) {
            if (combination[i] > 1) {
                result = result + (combination[i] * (combination[i] - 1) / 2);
            }
        }

        System.out.println(result);

    }
}
