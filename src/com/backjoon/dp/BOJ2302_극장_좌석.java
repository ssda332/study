package com.backjoon.dp;

import java.io.*;

public class BOJ2302_극장_좌석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // D[i] = i개의 좌석을 앉을수 있는 경우의 수
        // D[i] = D[i - 1] + D[i - 2] i번째가 vip석이 아닐경우 -> 자리 옮기기가 가능함
        // D[i] = D[i - 1] i번째나 i - 1번째가 vip석일 경우 -> 자리 옮기기가 불가능함 -> D[i- 2] 경우를 더하지 않음
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] D = new int[N + 1];
        boolean[] isVip = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int vip = Integer.parseInt(br.readLine());
            isVip[vip] = true;
        }

        D[0] = 1; D[1] = 1;
        for (int i = 2; i <= N; i++) {
            if (isVip[i] || isVip[i - 1]) {
                D[i] = D[i - 1];
            } else {
                D[i] = D[i - 1] + D[i - 2];
            }
        }

        System.out.println(D[N]);
    }
}
