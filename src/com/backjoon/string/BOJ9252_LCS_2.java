package com.backjoon.string;

import java.io.IOException;
import java.util.Scanner;

public class BOJ9252_LCS_2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.substring(i - 1, i).equals(s2.substring(j - 1, j))) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int startX = s2.length();
        int startY = s1.length();

//        sb.append(dp[startY][startX]).append("\n");

        while (dp[startY][startX] > 0) {
            if (s1.substring(startY - 1, startY).equals(s2.substring(startX - 1, startX))) {
                sb.insert(0, s1.substring(startY - 1, startY));
                startX--;
                startY--;
            } else {
                if (dp[startY - 1][startX] > dp[startY][startX - 1]) {
                    startY--;
                } else {
                    startX--;
                }
            }
        }

        sb.insert(0, "\n").insert(0, dp[s1.length()][s2.length()]).append("\n");

        System.out.println(sb);



    }
}
