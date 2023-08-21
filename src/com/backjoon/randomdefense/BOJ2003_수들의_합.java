package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003_수들의_합 {
    public static void main(String[] args) throws IOException {
        // 10:40
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] S = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < S.length; i++) {
            S[i] += S[i - 1] + A[i - 1];
        }

        int lo = 0;
        int hi = 1;
        int cnt = 0;
        while (hi <= N) {
//            System.out.println("lo : " + lo + ", hi : " + hi + ", cnt : " + cnt);

            if (S[hi] - S[lo] < M) {
                hi++;
            } else if (S[hi] - S[lo] == M){
                lo++;
                cnt++;
            } else {
                lo++;
            }
        }

        System.out.println(cnt);
    }
}
