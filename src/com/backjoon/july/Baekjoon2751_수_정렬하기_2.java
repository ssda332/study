package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2751_수_정렬하기_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr, 0, N - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = start;
        int i = start + 1;
        int j = end;

        while (i <= j) {
            while (arr[pivot] > arr[i] && i > 0) {
                i--;
            }

            while (arr[pivot] < arr[j] && j > i) {
                j--;
            }

            swap(arr, i++, j--);
        }
        swap(arr, pivot, j);

        quickSort(arr, start, j - 1);
        quickSort(arr, j + 1, end);

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
