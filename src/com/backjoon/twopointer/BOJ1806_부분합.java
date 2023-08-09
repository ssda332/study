package com.backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] A = new long[n + 1];
        long[] S = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            A[i] = Long.parseLong(st.nextToken());
            if (i == 0) {
                S[i] = A[i];
            }else {
                S[i] = S[i - 1] + A[i];
            }
        }

        /*
            틀린 이유
            처음부터 시작하는 연속된 합의 길이가 정답일 경우 -> 배열 길이 n + 1 해줘서 처음부터 시작하는 연속된 합도 체크를 해줌
            이럴경우 기존에 반복문도 조건을 배열의 길이에 맞게 고쳐줘야함
            예제 4 5
                1 2 2 3 <- 마지막 수까지 연속된 합의 길이가 정답일경우 체크해줘야함
         */
/*
        Arrays.stream(S)
                .forEach(System.out::println);
*/

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        boolean flag = false; // s를 넘는 합이 없을 경우 0 출력여부 변수

        while (start <= n - 1 && end <= n) {
            long gap = S[end] - S[start];
            if (gap >= s) {
                flag = true;
                if (min >= end - start) {
                    min = end - start;
                    start++;
                } else {
                    start++;
                }
            } else {
                end++;
            }
        }

        if (flag) {
            System.out.println(min);
        }else {
            System.out.println(0);
        }

    }
}
