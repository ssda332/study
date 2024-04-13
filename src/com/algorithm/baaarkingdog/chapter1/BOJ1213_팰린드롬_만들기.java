package com.algorithm.baaarkingdog.chapter1;

import java.util.*;

public class BOJ1213_팰린드롬_만들기 {

    static int[] A;
    static String str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        A = new int[26];


        for (int i = 0; i < str.length(); i++) {
            A[str.charAt(i) - 'A']++;
        }

        boolean flag = true;
        int oddNum = -1;

        for (int i = 0; i < 26; i++) {
            if (str.length() % 2 == 0) {
                if (A[i] % 2 == 1) {
                    flag = false;
                    break;
                }
            } else {
                if (A[i] % 2 == 1) {
                    if (oddNum != -1) {
                        flag = false;
                        break;
                    } else {
                        oddNum = i;
                    }
                }
            }
        }

        if (flag) {
            if (str.length() % 2 == 0) {
                evenPrint();
            } else {
                oddPrint(oddNum);
            }
        } else {
            System.out.println("I'm Sorry Hansoo");
        }
    }

    static void evenPrint() {
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < A[i] / 2; j++) {
                if (A[i] != 0) System.out.print((char)(i + 'A'));
            }
        }
        for (int i = 25; i >= 0; i--) {
            for (int j = 0; j < A[i] / 2; j++) {
                if (A[i] != 0) System.out.print((char)(i + 'A'));
            }
        }
    }
    // A 배열을 돌면서

    static void oddPrint(int oddNum) {
        for (int i = 0; i < 26; i++) {
            if (A[i] >= 2) {
                for (int j = 0; j < A[i] / 2; j++) {
                    System.out.print((char)(i + 'A'));
                }
            }
        }
// AABCBAA
        //ABACABA AABCBAA
        System.out.print((char)(oddNum + 'A'));

        for (int i = 25; i >= 0; i--) {
            if (A[i] >= 2) {
                for (int j = 0; j < A[i] / 2; j++) {
                    System.out.print((char)(i + 'A'));
                }
            }
        }
    }
}
