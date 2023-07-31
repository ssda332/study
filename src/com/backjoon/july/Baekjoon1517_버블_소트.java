package com.backjoon.july;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon1517_버블_소트 {
    public static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] tmp = new int[N];
        count = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, tmp, 0, N - 1);

        System.out.println(count);
    }

    public static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (end - start < 1) return;
        int mid = (start + end) / 2;
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

        while(index1 <= mid && index2 <= end) {
            if (tmp[index1] <= tmp[index2]) {
                arr[k++] = tmp[index1++];
            } else {
                count = count + index2 - k;
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
