package com.backjoon.dp;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ9711_피보나치 {

    static BigInteger[] fibo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        fibo = new BigInteger[10001];

        fibo[1] = new BigInteger("1");
        fibo[2] = new BigInteger("1");

        for (int j = 3; j <= 10000; j++) {
            fibo[j] = fibo[j - 1].add(fibo[j - 2]);
        }

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int P = Integer.parseInt(st.nextToken());
            BigInteger Q = new BigInteger(st.nextToken());

            bw.write("Case #" + i + ": " + fibo[P].remainder(Q) + "\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
