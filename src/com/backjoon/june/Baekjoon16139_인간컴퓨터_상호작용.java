package com.backjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16139_인간컴퓨터_상호작용 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[] alpha = new int[26];
        int[][] sum = new int[S.length()][26];

        for (int i = 0; i < S.length(); i++) {
            alpha[S.charAt(i) - 'a']++;
            sum[i] = alpha.clone();
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int idx = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int result = 0;
            if (start > 0) {
                result = sum[end][idx] - sum[start - 1][idx];
            } else {
                result = sum[end][idx];
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
