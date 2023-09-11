package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1431_시리얼_번호 {

    static String[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new String[N];

        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (A[i].length() > A[j].length()) {
                    swap(i, j);
                    continue;
                }

                int iSum = 0;
                int jSum = 0;
                int iDic = Integer.MAX_VALUE;
                int jDic = Integer.MAX_VALUE;
                for (int k = 0; k < A[i].length(); k++) {
                    if (A[i].charAt(k) >= '0' && A[i].charAt(k) <= '9') {
                        iSum += A[i].charAt(k) - '0';
                    }
                    if (A[j].charAt(k) >= '0' && A[j].charAt(k) <= '9') {
                        jSum += A[j].charAt(k) - '0';
                    }
                    if (iDic > A[i].charAt(k)) {
                        iDic = A[i].charAt(k);
                    }
                    if (iDic > A[j].charAt(k)) {
                        jDic = A[j].charAt(k);
                    }
                }
                if (iSum > jSum) {
                    swap(i, j);
                    continue;
                }

                if (iDic > jDic) {
                    swap(i, j);
                }

            }
        }

        Arrays.stream(A)
                .forEach(System.out::println);

    }

    static void swap(int i, int j) {
        String temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
