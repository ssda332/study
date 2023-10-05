package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ10816_숫자_카드_2_RE {

    static int N;
    static int M;
    static int[] cards;
    static int[] targets;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        for (int i = 0; i < M; i++) {
            int result = binarySearch(targets[i]);
            sb.append(result).append(" ");
        }

        System.out.println(sb);

    }

    static int binarySearch(int target) {
        return upper_bound(target) - lower_bound(target);
    }

    /**
     *  lower_bound는 mid와 target 같을때마다 right값을 mid로 맞춰줘야함 right 값을 mid로 내려야 일치하는 왼쪽 값에 도달 가능
     *  upper_bound는 반대로 left값을 mid+1로 맞춰야함 left값을 mid+1로 맞춰야 일치하는 오른쪽 값 + 1에 도달 가능
     */
    static int lower_bound(int target) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) / 2;

            if (cards[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    static int upper_bound(int target) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) / 2;

            if (cards[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}
