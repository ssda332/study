package com.backjoon.july;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1920_수_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] targetArr = new int[M];

        for (int i = 0; i < M; i++) {
            targetArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = 0; i < M; i++) {
            int target = targetArr[i];
            int start = 0;
            int end = N - 1;
            boolean flag = false;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (arr[mid] > target) {
                    end = mid - 1;
                }else if (arr[mid] < target) {
                    start = mid + 1;
                }else {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                bw.write(1 + "\n");
            }else {
                bw.write(0 + "\n");
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
