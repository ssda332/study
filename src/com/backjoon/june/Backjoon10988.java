package com.backjoon.june;

import java.util.Scanner;

public class Backjoon10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();
        int result = 1;

        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                result = 0;
            }
        }

        System.out.println(result);
    }
}
