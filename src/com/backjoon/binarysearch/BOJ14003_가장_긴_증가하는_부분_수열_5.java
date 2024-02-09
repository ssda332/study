package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ14003_가장_긴_증가하는_부분_수열_5 {
    static int N;
    static int[] A;
    static ArrayList<Integer> LIS;
    static int[] idxArr;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        LIS = new ArrayList<>();
        idxArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        LIS.add(A[0]);
        Arrays.fill(idxArr, -1);
        idxArr[0] = 0;

        for (int i = 1; i < N; i++) {
            if (A[i] > LIS.get(LIS.size() - 1)) {
                LIS.add(A[i]);
                idxArr[i] = LIS.size() - 1;

            } else {
                int hi = binarySearch(i);
                LIS.set(hi, A[i]);
                idxArr[i] = hi;
            }
        }

        output();

        System.out.println(answer);
        br.close();
    }

    static int binarySearch(int i) {
        int lo = -1;
        int hi = LIS.size() - 1;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (check(mid, i)) hi = mid;
            else lo = mid;

        }

        return hi;
    }

    static boolean check(int target, int i) {
        if (LIS.get(target) >= A[i]) return true;
        return false;
    }

    static void output() {
        int count = LIS.size();

        answer.append(count).append("\n");
        int idx = count - 1;
        Stack<Integer> stack = new Stack();

        for (int i = N - 1; i >= 0; i--) {
            if (idxArr[i] == idx) {
                stack.push(A[i]);
                idx--;
            }
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            answer.append(pop).append(" ");
        }
    }
}
