package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1456_거의_소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long[] arr = new long[10000001];

        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i + i; j < arr.length; j = j + i) {
                arr[j] = 0;
            }
        }

        int count = 0;

        for (int i = 2; i < 10000001; i++) {
            if (arr[i] == 0) continue;
            long num = arr[i];
            while ((double)arr[i] <= B / (double)num) {
                if ((double)arr[i] >= (double)A / (double)num) {
                    count++;
                }
                num = num * arr[i];
            }
        }

        System.out.println(count);
    }
}
