package com.backjoon.string;

import java.io.*;

public class BOJ2607_비슷한_단어 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String target = br.readLine();
        int[] alpha1 = new int[26];
        int[] alpha2;

        for (int i = 0; i < target.length(); i++) {
            int n = target.charAt(i) - 'A';
            alpha1[n]++;
        }

        for (int i = 1; i < N; i++) {
            String str = br.readLine();
            alpha2 = alpha1.clone();

            if (Math.abs(target.length() - str.length()) > 1) continue;

            for (int j = 0; j < str.length(); j++) {
//                if (alp)
            }
        }
    }

}
