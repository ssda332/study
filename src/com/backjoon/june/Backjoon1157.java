package com.backjoon.june;

import java.util.Scanner;

public class Backjoon1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();

        int[] alpha = new int[26];

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) < 97) {
                alpha[word.charAt(i) - 65]++;
            } else {
                alpha[word.charAt(i) - 97]++;
            }
        }


        int max = alpha[0];
        int index = 0;

        for (int i = 1; i < alpha.length; i++) {
            if (max < alpha[i]) {
                max = alpha[i];
                index = i;
            } else if (max == alpha[i]) {
                index = -1;
            }
        }

        if (index == -1) {
            System.out.println("?");
        } else {
            System.out.println((char)(65 + index));
        }


    }
}
