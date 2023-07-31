package com.backjoon.dp;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ9184_신나는_함수_실행 {

    static int[][][] D = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }else {
                //bw.write("w(" + a + ", " + b + ", " + c + ") = " + DP(a, b, c) + "\n");
                sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(DP(a ,b ,c)).append('\n');
            }

        }

        System.out.println(sb);
//        bw.flush();
//        bw.close();
        br.close();

    }

    static int DP(int a, int b, int c) {
//        if (D[a][b][c] >)

        if (a <= 0 || b <= 0 || c <= 0) {
            return D[a][b][c] = 1;
        }else if (a > 20 || b > 20 || c > 20) {
            return D[20][20][20] = DP(20, 20, 20);
        }else if (a < b && b < c) {
            return D[a][b][c] = DP(a, b, c-1) + DP(a, b-1, c-1) - DP(a, b-1, c);
        }else {
            return D[a][b][c] = DP(a-1, b, c) + DP(a-1, b-1, c) + DP(a-1, b, c-1) - DP(a-1, b-1, c-1);
        }
    }
}
