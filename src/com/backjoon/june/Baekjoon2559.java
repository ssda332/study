package com.backjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] sum = new int[N - K + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            sum[0] += arr[i];
        }

        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + arr[i + K - 1] - arr[i - 1];
        }

        int result = Arrays.stream(sum)
                .max()
                .getAsInt();

        System.out.println(result);

    }
}
