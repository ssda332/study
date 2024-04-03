package com.backjoon.string;

import java.io.*;
import java.util.*;

public class BOJ1969_DNA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] A = new String[N];

        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }

        String answer1 = "";
        int answer2 = 0;

        for (int i = 0; i < M; i++) {
            int[] alpha = new int[26];

            for (int j = 0; j < N; j++) {
                char c = A[j].charAt(i);
                alpha[c - 'A']++;
            }

            int max = alpha[0]; int idx = 0;

            for (int j = 1; j < 26; j++) {
                if (alpha[j] > max) {
                    max = alpha[j];
                    idx = j;
                }
            }

            answer2 += N - max;
            answer1 += Character.toString(idx + 'A');

        }

        System.out.println(answer1);
        System.out.println(answer2);

    }
}
