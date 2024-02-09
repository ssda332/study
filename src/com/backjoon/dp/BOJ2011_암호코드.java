package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ2011_암호코드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pw = br.readLine();

        // DP[i] : i번째 자릿수까지 왔을때 암호 해석 경우의수
        // DP[i] = if (i-1번째 자릿수 <= 2 && i번째 자릿수 <= 6) DP[i - 2] + DP[i - 1] else DP[i - 1]
        // 25일때 2로 표현할수 있는 가짓수는 하나 25이면 2와 5 그리고 251 2 25114
        // 1 2 2 4 6

        int[] DP = new int[5001];
        DP[0] = 1; DP[1] = 1;

        if (pw.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        for (int i = 2; i <= pw.length(); i++) {
            int cur = pw.charAt(i - 1) - '0';
            int pre = pw.charAt(i - 2) - '0';

            if ((cur == 0 && pre >= 3) || cur == 0 && pre == 0) {
                System.out.println(0);
                return;
            }

            int sum = Integer.parseInt("" + pre + cur);

            if (sum >= 27) {
                DP[i] = DP[i - 1] % 1000000;
            } else if (cur == 0) {
                DP[i] = DP[i - 2] % 1000000;
            } else if (pre == 0) {
                DP[i] = DP[i - 1] % 1000000;
            } else {
                DP[i] = (DP[i - 2] + DP[i - 1]) % 1000000;
            }

        }

        System.out.println(DP[pw.length()]);
    }
}
