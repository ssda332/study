package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ9251_LCS_TOP_DOWN {

    static String s1;
    static String s2;
    static Integer[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();
        int N = s1.length();
        int M = s2.length();

        DP = new Integer[N + 1][M + 1];

        System.out.println(lcs(N, M));
        System.out.println(1);
    }

    static int lcs(int x, int y) {
        if (x <= 0 || y <= 0) {
            return 0;
        }

        if (DP[x][y] == null) {
            DP[x][y] = 0;

            if (s1.charAt(x - 1) == s2.charAt(y - 1)) {
                DP[x][y] = lcs(x - 1, y - 1) + 1;
            } else {
                DP[x][y] = Math.max(lcs(x - 1, y), lcs(x, y - 1));
            }
        }


        return DP[x][y];
    }
}
