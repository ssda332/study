package com.backjoon.sort;

import java.io.*;
import java.util.Arrays;

public class BOJ11931_수_정렬하기_4 {

    static int[] A;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        tmp = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);
//        merge_sort(0, N - 1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
            sb.append(A[i]).append("\n");
        }
        System.out.println(sb);
        bw.flush();
        bw.close();

    }

    static void merge_sort(int s, int e) {
        if (e - s < 1) return;
        int m = (s + e) / 2;

        merge_sort(s, m);
        merge_sort(m + 1, e);

        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }
        // 2 3 4 5   m = 3 m + 1 = 4
        int k = s;
        int index1 = s;
        int index2 = m + 1;

        while (index1 <= m && index2 <= e) {
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index1];
                k++;
                index1++;
            } else {
                A[k] = tmp[index2];
                k++;
                index2++;
            }
        }

        while (index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }

        while (index2 <= m) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
