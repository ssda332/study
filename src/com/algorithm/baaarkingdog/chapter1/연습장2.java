package com.algorithm.baaarkingdog.chapter1;

import java.io.*;
import java.util.*;

public class 연습장2 {

    static int N;
    static int C;
    static int[] A;
    static class Info {
        int freq;
        int order;

        public Info(int freq, int order) {
            this.freq = freq;
            this.order = order;
        }
    }
    static HashMap<Integer, Info> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());

            if (map.containsKey(A[i])) {
                Info info = map.get(A[i]);
                info.freq++;
            } else {
                map.put(A[i], new Info(1, i));
            }

        }

//        Arrays.sort(A);
        quickSort_2(0, N - 1);

        StringBuilder sb = new StringBuilder();

        Arrays.stream(A)
                .forEach(n -> {
                    sb.append(n).append(" ");
                });

        System.out.println(sb);
    }

    static void quickSort_2(int start, int end) {
        int pivot = partition(start, end);

        quickSort_2(start, pivot - 1);
        quickSort_2(pivot + 1, end);
    }

    static int partition(int start, int end) {
        if (start + 1 == end) {
            if (compare(A[end], A[start])) swap(start, end); // A[start] > A[end]
            return end;
        }

        int pivot = A[start];

        int i = start;
        int j = end - 1;

        while (i <= j) {
            while (j >= start + 1 && compare(pivot, A[i])) { // 빈도수가 작다 A[i] < pivot
                i++;
            }

            while (i <= end - 1 && compare(A[j], pivot)) { // 빈도수가 크다 A[j] > pivot
                j--;
            }

            if (i <= j) {
                swap(i++, j--);
            }
        }

        A[start] = A[j];
        A[j] = pivot;

        return pivot;
    }

    static boolean compare(int i, int j) {
        Info i1 = map.get(A[i]);
        Info i2 = map.get(A[j]);

        if (i1.freq == i2.freq) {
            if (i1.order <= i2.order) return false;
            else return true;
        } else if (i1.freq > i2.freq) {
            return false;
        } else {
            return true;
        }
    }

    static void swap(int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
