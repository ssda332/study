package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ1010_다리_놓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // n! / (n - r)! r!
        // D[i][j] : i Combination j
        /**
         * 1 1 1 2 2 1
         * 3 1 3 2 3 3   3! / (3 - 1)! 1!    3! / (3 - 2)! 2!   21
         *               10! / (10 - 7)! 7!  10! / (10 - 8)! 8!      3! 7! // 2! 8! (i - j) 나눠주고 j 곱해주고
         * N이 늘어나면 i - 1 곱해주기
         * M이 늘어나면 옆에꺼에서 (i - j - 1) 나눠주고 j 곱해주기
         * 초기값 : D[1][1] = 1, D[i]
         * 시간복잡도 O(NM)
         * 점화식 : D[i][j] =
         */
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long answer = 1;
            int cnt = 1;
            for (int i = M; i > M - N; i--) {
                answer *= i;
                answer /= cnt;
                cnt++;
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }
}
