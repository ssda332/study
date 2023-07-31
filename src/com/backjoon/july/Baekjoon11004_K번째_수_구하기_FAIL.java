package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11004_K번째_수_구하기_FAIL {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, N - 1, K - 1);

        System.out.println(arr[K - 1]);
    }

    public static void quickSort(int[] arr, int start, int end, int K) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            if (pivot == K) {
                return;
            }else if (pivot > K) {
                quickSort(arr, start, pivot - 1, K);
            }else {
                quickSort(arr, pivot + 1, end, K);
            }
        }
    }

    public static int partition(int[] arr, int start, int end) {
        if (start + 1 == end) {
            if (arr[start] > arr[end]) swap(arr, start, end);
            return end;
        }
        int middle = start + end / 2;
        swap(arr, start, middle);
        int pivot = arr[start];
        int i = start + 1;
        int j = end;
        while (i <= j) {
            while (j >= start + 1  && pivot < arr[j]) {
                j--;
            }
            while (i <= end && pivot > arr[i]) {
                i ++;
            }
            if (i <= j) {
                swap(arr, i++, j--);
            }
        }
        arr[start] = arr[j];
        arr[j] = pivot;
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
