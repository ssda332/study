package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14002_가장_긴_증가하는_부분_수열_4 {
    public static void main(String[] args) throws IOException {
        //0930
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] D = new int[N];

        // D[i] : i번째까지 수열에서 가장 긴 증가하는 부분수열의 길이
        // if (D[j] + 1 > D[i] && A[j] > A[i]) D[i] = D[j] + 1
        Arrays.fill(D, 1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && D[i] < D[j] + 1) {
                    D[i] = D[j] + 1;

                }
            }
        }

        Arrays.stream(D)
                .forEach(System.out::println);

        int val = Arrays.stream(D)
                .max().getAsInt();
        System.out.println(val);

        int cnt = val;
        int[] DP = new int[cnt];
        for(int i = N - 1; i >= 0; i--) {
            System.out.println("i : " + i + ", D[i] : " + D[i]);
            if(D[i] == cnt) {
                DP[cnt - 1] = A[i];
                cnt--;
            }
        }

        for (int i : DP) {
            System.out.print(i + " ");
        }
    }
}
