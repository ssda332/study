package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1940_주몽의_명령 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        int i = 0;
        int j = N - 1;

        while (i < j) {
            if (arr[i] + arr[j] == M) {
                count++;
                i++;
                j--;
            } else if (arr[i] + arr[j] < M) {
                i++;
            } else if (arr[i] + arr[j] > M) {
                j--;
            }
        }

        System.out.println(count);
        br.close();

    }
}
