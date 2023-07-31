package com.backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9184_신나는_함수_실행_BUTTOM_UP {

    static int[][][] D = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int a = 0; a <= 20; a++) {
            for (int b = 0; b <= 20; b++) {
                for (int c = 0; c <= 20; c++) {
                    if (a <= 0 || b <= 0 || c <= 0) {
                        D[a][b][c] = 1;
                    }else if (a < b && b < c) {
                        D[a][b][c] = D[a][b][c - 1] + D[a][b - 1][c - 1] - D[a][b - 1][c - 1];
                    }else {
                        D[a][b][c] = D[a - 1][b][c] + D[a - 1][b - 1][c] + D[a - 1][b][c - 1] - D[a - 1][b - 1][c - 1];
                    }
                }
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int pa = a;
            int b = Integer.parseInt(st.nextToken());
            int pb = b;
            int c = Integer.parseInt(st.nextToken());
            int pc = c;

            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            if (a < 0) a = 0;
            if (b < 0) b = 0;
            if (c < 0) c = 0;

            if (a <= 0 || b <= 0 || c <= 0) {
                sb.append("w(" + pa + ", " + pb + ", " + pc + ") = ").append(1).append('\n');
            } else if (a > 20 || b > 20 || c > 20) {
                sb.append("w(" + pa + ", " + pb + ", " + pc + ") = ").append(D[20][20][20]).append('\n');
            } else {
                sb.append("w(" + pa + ", " + pb + ", " + pc + ") = ").append(D[a][b][c]).append('\n');
            }

        }

        System.out.println(sb);

    }
}
