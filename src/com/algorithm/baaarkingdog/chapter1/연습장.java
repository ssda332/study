package com.algorithm.baaarkingdog.chapter1;

import java.io.*;
import java.util.StringTokenizer;

public class 연습장 {

    static int N;
    static int K;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(0, N - 1);

        System.out.println(A[K - 1]);

    }

    static void quickSort(int start, int end) {
        int pivot = partition(start, end);

        if (pivot == K) return;
        else if (K < pivot) quickSort(start, pivot - 1);
        else quickSort(pivot + 1, end);
    }

    // 1 2 3 4 5 ...   O(n^2)

    static int partition(int start, int end) {
        if (start + 1 == end) {
            if (A[start] > A[end]) swap(start, end);
            return end;
        }

        // K번째 수 효율 위해 중간값을 피벗으로 정해 시작값이랑 바꿔줌
        int mid = (start + end) / 2;
        swap(start, mid);
        int pivot = A[start];

        int i = start + 1;
        int j = end;

        while (i <= j) {
            while (A[i] < pivot && j >= start + 1) {
                i++;
            }

            while (A[j] > pivot && i < end) {
                j--;
            }

            if (i <= j) {
                swap(i++, j--);
            }
        }

        A[start] = A[j];
        A[j] = pivot;

        return j;
    }

    static void swap(int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
