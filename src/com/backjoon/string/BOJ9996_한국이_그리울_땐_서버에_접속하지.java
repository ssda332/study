package com.backjoon.string;

import java.io.*;

public class BOJ9996_한국이_그리울_땐_서버에_접속하지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        int starIdx = pattern.indexOf("*");
        char[] left = new char[starIdx];
        char[] right = new char[pattern.length() - starIdx - 1];

        for (int i = 0; i < left.length; i++) {
            left[i] = pattern.charAt(i);
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = pattern.charAt(pattern.length() - i - 1);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            boolean flag = true;

            if (pattern.length() - 1 > str.length()) {
                sb.append("NE").append("\n");
                continue;
            }

            for (int j = 0; j < left.length; j++) {
                if (str.charAt(j) != left[j]) {
                    flag = false;
                }
            }

            for (int j = 0; j < right.length; j++) {
                if (str.charAt(str.length() - j - 1) != right[j]) {
                    flag = false;
                }
            }

            if (flag) sb.append("DA").append("\n");
            else sb.append("NE").append("\n");

        }

        System.out.println(sb);
    }
}
