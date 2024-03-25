package com.backjoon.string;

import java.io.*;
import java.util.*;

public class BOJ3613_JAVA_VS_CPP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        if (isUpperCase(str.charAt(0)) || str.charAt(0) == '_') {
            System.out.println("Error!");
            return;
        }

        if (str.contains("_")) {
            for (int i = 1; i < str.length() - 1; i++) {
                if (str.charAt(i) == '_') {
                    if (isUpperCase(str.charAt(i + 1)) || str.charAt(i + 1) == '_') {
                        System.out.println("Error!");
                        return;
                    }

                    String before = "" + str.charAt(i) + str.charAt(i + 1);
                    str = str.replaceFirst(before, before.toUpperCase().substring(1, 2));
                } else {
                    if (isUpperCase(str.charAt(i))) {
                        System.out.println("Error!");
                        return;
                    }
                }

            }

            if (str.charAt(str.length() - 1) == '_') {
                System.out.println("Error!");
                return;
            }
        } else {
            for (int i = 1; i < str.length(); i++) {
                if (isUpperCase(str.charAt(i))) {
                    String before = "" + str.charAt(i);
                    str = str.replaceFirst(before, "_" + before.toLowerCase());
                }
            }
        }

        System.out.println(str);
    }

    // 대문자인지 확인
    static boolean isUpperCase(Character c) {
        if (c >= 65 && c <= 90) return true;
        return false;
    }

}
