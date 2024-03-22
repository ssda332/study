package com.algorithm.baaarkingdog.chapter1;

import java.io.*;
import java.util.*;

public class 연습장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] D = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        D[0] = 1;
        // D[i] : i번쨰까지의 수열에서 합이 가장 긴 증가하는 부분수열의 값
        for (int i = 0; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (A[i] > A[j]) {
                    if (D[j] + 1 > D[i]) D[i] = D[j] + 1;
                }
            }
        }

        System.out.println(Arrays.stream(D).max().getAsInt());
    }
}
