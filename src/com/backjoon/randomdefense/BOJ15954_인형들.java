package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15954_인형들 {

    static int N;
    static int K;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = K - 1;
        double result = Double.MAX_VALUE;

        for (int i = K - 1; i < N; i++) {
            for (int j = 0; j <= i - K + 1; j++) {
                if (i - j + 1 < K) continue;
                double average = average(j, i);
                double deviation = deviation(average, j, i);
                if (result > deviation) {
                    result = deviation;
                }

                System.out.println("result : " + deviation + ", i : " + i + ", j : " + j);
            }
        }

        System.out.println(result);
    }

    static double average(int start, int end) { // 평균
        double sum = 0;

        for (int i = start; i <= end; i++) {
            sum += A[i];
        }

        int cnt = end - start + 1;

        return sum / cnt;
    }

    static double deviation(double average, int start, int end) { // 표준편차
        double sum = 0;

        for (int i = start; i <= end; i++) {

            sum += Math.pow(A[i] - average, 2);
        }

        int cnt = end - start + 1;

        return Math.sqrt(sum / cnt);
    }

}
