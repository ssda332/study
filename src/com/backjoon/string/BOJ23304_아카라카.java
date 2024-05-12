package com.backjoon.string;

import java.io.*;

public class BOJ23304_아카라카 {

    static String S;
    static boolean flag = true;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();

        check(S.length() - 1);

        if (flag) System.out.println("AKARAKA");
        else System.out.println("IPSELENTI");
    }

    static void check(int end) {
        if (end <= 1) return;

        int length = end / 2;
        if (end % 2 == 1) length++;

        for (int i = 0; i < length; i++) {
            if (S.charAt(i) != S.charAt(end - i)) {
                flag = false;
                return;
            }
        }

        check(length - 1);

    }
}
