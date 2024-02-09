package com.backjoon.binarysearch;

import java.io.*;

public class BOJ1789_수들의_합 {

    static long S;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Long.parseLong(br.readLine());

        System.out.println(binarySearch());
    }

    static long binarySearch() {
        long lo = 1;
        long hi = 4294967295L;

        while (lo + 1L < hi) {
            long mid = (lo + hi) / 2;

            if (check(mid)) {
                hi = mid;
            } else {
                lo = mid;
            }

        }

        return lo;
    }

    static boolean check(long target) {
        long sum = target * (target + 1) / 2;

        if (sum > S) return true;
        else return false;
    }

}
