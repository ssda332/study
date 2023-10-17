package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ2805_나무_자르기 {

    public static void main(String[] args) throws IOException {
        // max min 값 구하고 이분탐색
        // 시간복잡도 O(1000000log2000000000) = O(9000000)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int left = 0;
        int right = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, A[i]);
        }

        while (left < right) {
            int middle = left + (right - left) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (middle == 0) {
                    sum += A[i];
                    continue;
                }

                if (A[i] / middle > 0) { // 나무를 잘라서 남는 나무가 있으면
                    sum += (A[i] - middle);
                }
            }

            // lower_bound인가 upper_bound인가 고려 필요 (높이의 최대값이므로)
            // upper_bound로 풀이

            if (sum >= M) { //
                left = middle + 1;
            } else {
                right = middle;
            }

        }

        System.out.println(left - 1);

    }
}
