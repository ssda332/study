package com.backjoon.june;

import java.util.Scanner;

public class Backjoon1316 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int result = 0;
        sc.nextLine();

        for (int i = 0; i < num; i++) {
            String str = sc.nextLine();
            if (groupWord(str)) {
                result++;
            }
        }

        System.out.println(result);

    }

    public static boolean groupWord(String word) {
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i - 1) != word.charAt(i)) {
                for (int j = i + 1; j < word.length(); j++) {
                    if (word.charAt(i - 1) == word.charAt(j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
