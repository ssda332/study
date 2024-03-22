package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ14501_퇴사_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N + 2];
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        /**
         *
         * D[i] : i일부터 마지막날까지 받을 수 있는 금액 최대값
         * (N - i는 남은일수 Ti는 시작일에 예약 잡을경우 소요되는 시간)
         * if (N - i + 1 < T[i]) D[i] = D[i + 1] i일에 예약을 잡을수 없으므로 i+1일부터 마지막날까지 받을수 있는 금액과 같다
         * else D[i] = Max( P[i] + D[i + T[i]] , D[i + 1] ) i일에 예약 잡을수 있으면 일을 했을경우와 일을 안했을경우 최대 금액을 비교해서 높은 액수를 적용한다
         *
         */
        for (int i = N; i > 0; i--) {
            if (N - i + 1 < T[i]) D[i] = D[i + 1];
            else D[i] = Math.max(D[i + 1], D[i + T[i]] + P[i]);
        }

        System.out.println(D[1]);
    }
}
