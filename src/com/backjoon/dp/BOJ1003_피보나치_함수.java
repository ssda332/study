package com.backjoon.dp;

import java.io.*;

public class BOJ1003_피보나치_함수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // D[i][] = fibo(i)일 때 0과 1의 개수
        // D[i][0] = fibo(i)일 때 0의 개수
        // D[i][1] = fibo(i)일 때 0의 개수

        int T = Integer.parseInt(br.readLine());

        int[][] D = new int[41][2];

        D[0][0] = 1; D[0][1] = 0;
        D[1][0] = 0; D[1][1] = 1;
        D[2][0] = 1; D[2][1] = 1;

        for (int j = 3; j <= 40; j++) {
            D[j][0] = D[j - 1][0] + D[j - 2][0];
            D[j][1] = D[j - 1][1] + D[j - 2][1];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            bw.write(D[N][0] + " " + D[N][1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }


}
