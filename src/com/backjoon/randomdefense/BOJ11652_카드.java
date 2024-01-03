package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ11652_카드 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];

        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(A);


        long val = A[0];
        int cnt = 1;
        int max = 1;
        long maxVal = A[0];
        for (int i = 1; i < N; i++) {
            if (val != A[i]) {

                // 횟수가 많을 경우 (많을 경우만 체크하고 같은경우를 빼면 자동적으로 가장 많은게 여러가지면 작은거 출력함)
                if (cnt > max) {
                    max = cnt;
                    maxVal = val;
                }

                val = A[i];
                cnt = 1;

            } else {
                cnt++;

            }
        }

        if (cnt > max) {
            maxVal = val;
        }


        System.out.println(maxVal);

    }
}
