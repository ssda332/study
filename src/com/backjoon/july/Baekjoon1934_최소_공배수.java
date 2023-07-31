package com.backjoon.july;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon1934_최소_공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = LCM(a, b);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    public static int LCM(int a, int b) {
        return a / GCD(a, b) * b;
    }
}
