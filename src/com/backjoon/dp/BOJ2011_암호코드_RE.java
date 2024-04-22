package com.backjoon.dp;

import java.util.*;

public class BOJ2011_암호코드_RE {

    static String password;
    static int[] DP;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        password = sc.nextLine();
        DP = new int[password.length() + 2];
        // DP[i] = i번째부터 끝번째까지 패스워드의 해석이 될 수 있는 가짓수
        // if (2자리 암호가 가능하면) DP[i] = DP[i + 1] + DP[i + 2]
        // else DP[i] = DP[i + 1]
        int n = password.length();


//        DP[n] = 1; DP[n + 1] = 1;
//        if (password.charAt(n - 1) == '0') DP[n] = 0;
        if (password.charAt(0) != '0') {
            DP[0] = 1;
            if (password.length() >= 2 && (password.charAt(1) != '0' || password.charAt(1) < '3')) {
                DP[1] = 1;
            }
        }
        if (password.length() >= 2 && password.charAt(1) != '0') DP[1] = 1;

        for (int i = 2; i < n; i++) {

        }
        /*for (int i = n - 2; i >= 1; i--) {
            int cur = password.charAt(i - 1) - '0';
            int pre = password.charAt(i) - '0';

            if (cur > 2 && pre == 0) {
                DP[i] = 0; DP[i + 1] = 0;
            }

            if (cur == 1 || (cur == 2 && pre >= 0 && pre < 7)) {
                if (cur == 1 && pre == 0) DP[i] = DP[i + 1];
                else DP[i] = (DP[i + 1] + DP[i + 2]) % 1000000;
            } else {
                DP[i] = DP[i + 1];
            }
        }*/


        System.out.println(DP[1]);
    }

}
