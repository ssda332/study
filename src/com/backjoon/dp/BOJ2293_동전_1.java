package com.backjoon.dp;

import java.util.*;
import java.io.*;

public class BOJ2293_동전_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        int[] D = new int[k + 1];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        D[0] = 1; // 0원을 만드는 경우의 수는 0개의 동전을 선택하는 방법이므로 1가지입니다.
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= coin[i]) D[j] += D[j - coin[i]];
            }
        }

        System.out.println(D[k]);
    }
}
