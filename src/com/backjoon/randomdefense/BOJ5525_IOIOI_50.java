package com.backjoon.randomdefense;

import java.io.*;

public class BOJ5525_IOIOI_50 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int result = 0;

        String chk = "IOI";
        for (int i = 2; i <= N; i++) {
            chk += "OI";
        }

        int length = chk.length();

        for (int i = 0; i <= M - length; i++) {
            String s = S.substring(i, length + i);
            if (s.equals(chk)) result++;
        }

        System.out.println(result);
    }
}
