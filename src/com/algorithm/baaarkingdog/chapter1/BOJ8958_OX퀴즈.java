package com.algorithm.baaarkingdog.chapter1;

import java.io.*;

public class BOJ8958_OX퀴즈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int[] DP = new int[str.length()];
            if (str.charAt(0) == 'O') DP[0] = 1;

            int sum = DP[0];

            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) == 'O') DP[i] = DP[i - 1] + 1;
                sum += DP[i];
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
