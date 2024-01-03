package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ10815_숫자_카드 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int lo = -1;
            int hi = A.length;
            boolean flag = false;

            while (lo + 1 < hi) {
                int mid = (lo + hi) / 2;

                if (target > A[mid]) {
                    lo = mid;
                } else if (target < A[mid]){
                    hi = mid;
                } else {
                    flag = true;
                    break;
                }

            }

            if (flag) sb.append(1).append(" ");
            else sb.append(0).append(" ");


        }

        System.out.println(sb);
    }

}
