package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ2294_동전_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
        }

        // D[i] : i원을 만드는데 드는 최소 동전 개수
        int[] D = new int[k + 1];
        Arrays.fill(D, 10001);
//        Arrays.sort(coins);
        D[0] = 0;

        for (int i = 0; i < n; i++) {
            int coin = coins[i];

            for (int j = coin; j <= k; j++) {
                D[j] = Math.min(D[j], D[j - coin] + 1);

                /*if (D[j] > D[j - coin] + 1) {
                    D[j] = D[j - coin] + 1;
                }*/
            }
        }

        if (D[k] > 10000) {
            System.out.println(-1);
        } else {
            System.out.println(D[k]);
        }

    }
}
