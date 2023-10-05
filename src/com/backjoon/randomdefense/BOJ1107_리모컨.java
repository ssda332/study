package com.backjoon.randomdefense;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1107_리모컨 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] buttons = new boolean[10];

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                buttons[num] = true;
            }
        }

        int result = Math.abs(N - 100);

        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int length = str.length();
            boolean isBreak = false;

            for (int j = 0; j < length; j++) {
                if (buttons[str.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }

            if (!isBreak) {
                int cnt = Math.abs(i - N) + length;

                if (result > cnt) {
                    result = cnt;
                }
            }

        }

        System.out.println(result);

    }
}
