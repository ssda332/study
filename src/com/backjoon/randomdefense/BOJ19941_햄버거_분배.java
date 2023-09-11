package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ19941_햄버거_분배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        String[] table = new String[N];
        boolean[] check = new boolean[N];

        for (int i = 0; i < N; i++) {
            table[i] = str.substring(i, i + 1);
        }

        int sum = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i].equals("P")) {
                int start = (i - K < 0) ? 0 : i - K;
                int end = (i + K > table.length - 1) ? table.length - 1 : i + K;

                for (int j = start; j <= end; j++) {
                    if (!check[j] && table[j].equals("H")) {
                        check[j] = true;
                        sum++;
                        break;
                    }
                }
            }
        }

        System.out.println(sum);

    }
}
