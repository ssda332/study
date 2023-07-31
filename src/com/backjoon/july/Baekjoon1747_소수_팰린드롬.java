package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1747_소수_팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[1003002];

        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }

        for (int i = 2; i < Math.sqrt(A.length); i++) {
            if (A[i] == 0) continue;
            for (int j = i + i; j < A.length; j = j + i) {
                A[j] = 0;
            }
        }

        int i = N;
        while (true) {
            if (A[N] != 0) {
                if (palindrome(N)) {
                    System.out.println(N);
                    break;
                }
            }

            N++;
        }


    }

    public static boolean palindrome(int num) {
        String number = num + "";
        int start = 0;
        int end = number.length() - 1;
        boolean flag = true;

        while (start <= end) {
            if (number.charAt(start) != number.charAt(end)) {
                flag = false;
                break;
            }
            start++;
            end--;
        }

        return flag;
    }
}
