package com.algorithm.baaarkingdog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 에르디 노바 사용횟수
        int M = Integer.parseInt(st.nextToken()); // 오리진 스킬 사용횟수
        boolean[] A = new boolean[10000001];
        boolean[] B = new boolean[10000001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[Integer.parseInt(st.nextToken())] = true;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[Integer.parseInt(st.nextToken())] = true;
        }

        int result1 = 0;
        int result2 = 0;

        for (int i = 1; i <= 1000000; i++) {
            if (A[i]) {
                result1++;
                i += 99;
            }
        }

        for (int i = 1; i <= 1000000; i++) {
            if (B[i]) {
                result2++;
                i += 359;
            }
        }

        System.out.print(result1 + " " + result2);
    }
}
