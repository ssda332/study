package com.backjoon.randomdefense;

import java.util.*;
import java.io.*;

public class BOJ3067_Coins {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // D[i] = i원을 만드는 경우의 수
        // k[j] = j번째 동전
        // if (i >= k[j]) D[i] = D[i] + D[i - k[j]]
        // else D[i] = D[i]

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] coin = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(br.readLine());
            int[] D = new int[money + 1];

            for (int i = 0; i < N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            D[0] = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < D.length; j++) {
                    if (j >= coin[i]) D[j] = D[j] + D[j - coin[i]];
                }
            }

            sb.append(D[money]).append("\n");
        }

        System.out.println(sb);
    }
}
