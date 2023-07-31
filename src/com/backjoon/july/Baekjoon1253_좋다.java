package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1253_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int count = 0;

        for (int i = 0; i < N; i++) {
            int start_num = 0;
            int end_num = N - 1;
            while (end_num > start_num) {
                if (arr[start_num] + arr[end_num] == arr[i]) {
                    if (start_num != i && end_num != i) {
                        count++;
                        break;
                    }else if (start_num == i) {
                        start_num++;
                    }else if (end_num == i) {
                        end_num--;
                    }
                }else if (arr[start_num] + arr[end_num] < arr[i]) {
                    start_num++;
                }else {
                    end_num--;
                }
            }
        }

        System.out.println(count);
        br.close();

    }
}
