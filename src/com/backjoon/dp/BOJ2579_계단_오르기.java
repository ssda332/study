package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579_계단_오르기 {

    static int[][] D;
    static int[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        S = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            S[i] = Integer.parseInt(br.readLine());
        }

        D = new int[K + 1][3];

        //D[i] = i번째 계단에 올랐을때 총합의 최대값 (연속해서 3개의 계단을 밟지 말아야 한다는 식 성립 x)
        //D[i][j] 현재까지 j개의 계단을 연속해서 밟고 i번째 계단에 올랐을때 총합의 최대값 단 i번째 계단은 반드시 밟아야 함

        // D[K][1] = max( D[K - 2][1], D[K - 2][2] ) + S[K]
        // D[K][2] = D[K - 1][1] + S[K]
        // result = max( D[K][1], D[K][2] )
        D[1][1] = S[1];
        D[1][2] = 0;
        if (K > 1) {
            D[2][1] = S[2];
            D[2][2] = S[1] + S[2];
        }


        for (int i = 3; i <= K; i++) {
            D[i][1] = Math.max(D[i - 2][1], D[i - 2][2]) + S[i];
            D[i][2] = D[i - 1][1] + S[i];
        }

        System.out.println(Math.max(D[K][1], D[K][2]));

    }

}
