package com.leetCode;

import java.io.*;
import java.util.*;

public class Daily20231006_IntegerBreak {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // dp[i] = i가 양의 정수의 합으로 나뉘었을 때 정수의 곱들의 최대값
        // dp[i] = Max(dp[i], j * dp[i - j]) O(n^2)

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < n; j++) {
                if (i - j >= 0) dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
        }

        System.out.println(dp[n]);
    }
}
