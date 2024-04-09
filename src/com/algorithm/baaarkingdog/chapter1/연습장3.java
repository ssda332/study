package com.algorithm.baaarkingdog.chapter1;

import java.io.*;
import java.util.*;

public class 연습장3 {

    static String s1;
    static String s2;
    static Integer[][] DP;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        s1 = sc.nextLine();
        s2 = sc.nextLine();

        int N = s1.length();
        int M = s2.length();
        DP = new Integer[N + 1][M + 1];

        int answer = lcs(N, M);
        System.out.println(answer);
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
