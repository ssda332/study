package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1016_제곱이_아닌_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());


/*        double rootMin = Math.sqrt(min);
        double rootMax = Math.sqrt(min);

        int[] A = new int[1000001];

        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }

        for (int i = 2; i < Math.sqrt(A.length); i++) {
            if (A[i] == 0) continue;
            for (int j = i + i; j < A.length; j = j + i) {
                A[j] = 0;
            }
        }

        int count = 0;

        while (rootMin <= rootMax) {
            boolean flag = true;

            for (int i = 2; i < A.length; i++) {
                if (rootMin % i == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) count++;
            min++;
            rootMin = Math.sqrt(min);
        }

        System.out.println(count);*/
    }
}
