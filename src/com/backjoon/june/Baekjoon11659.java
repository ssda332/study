package com.backjoon.june;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int length = Integer.parseInt(st.nextToken());
        int loop = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long[] sumArr = new long[length + 1];

        for (int i = 1; i <= length; i++) {
            sumArr[i] = sumArr[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(sumArr[end] - sumArr[start - 1]).append("\n");
        }

        System.out.println(sb);

    }
}
