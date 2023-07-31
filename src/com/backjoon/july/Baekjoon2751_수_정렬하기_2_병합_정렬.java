package com.backjoon.july;

import java.io.*;

public class Baekjoon2751_수_정렬하기_2_병합_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] tmp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(arr, tmp, 0, N - 1);
        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();

    }

    public static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        int mid = (start + end) / 2; // 0 ~ 5 = 2
        if (start < end) {
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid + 1, end);
        }

        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }

        int k = start;
        int index1 = start;
        int index2 = mid + 1;

        while (index1 <= mid && index2 <= end) {
            if (tmp[index1] < tmp[index2]) {
                arr[k++] = tmp[index1++];
            }else {
                arr[k++] = tmp[index2++];
            }
        }

        while (index1 <= mid) {
            arr[k++] = tmp[index1++];
        }

        while (index2 <= end) {
            arr[k++] = tmp[index2++];
        }

    }

}
