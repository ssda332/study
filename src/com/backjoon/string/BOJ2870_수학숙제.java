package com.backjoon.string;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BOJ2870_수학숙제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<BigInteger> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            boolean flag = false;
            int startIdx = 0;
            int endIdx = 0;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c >= '0' && c <= '9') {
                    if (!flag) {
                        startIdx = j;
                    } /*else if (flag) {
                        if (s.charAt(j - 1) == '0') {
                            startIdx++;
                        }
                    }*/
                    flag = true;
                } else {
                    endIdx = j;

                    if (flag) {
                        list.add(new BigInteger(extractZero(s, startIdx, endIdx)));
//                        list.add(s.substring(startIdx, endIdx));
                    }

                    flag = false;

                }

            }

            if (flag) {
//                list.add(s.substring(startIdx, s.length()));
                list.add(new BigInteger(extractZero(s, startIdx, s.length())));
            }
        }

        /*Collections.sort(list, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) > o2.charAt(i)) return 1;
                    return -1;
                }

                return 0;
            } else {
                return Integer.compare(o1.length(), o2.length());
            }

        });*/

        Collections.sort(list);
        list.stream().forEach(s -> {
            System.out.println(s);
        });

    }

    static String extractZero(String num, int startIdx, int endIdx) {
        String sub = num.substring(startIdx, endIdx);
        int idx = 0;

        for (int i = 0; i < sub.length(); i++) {
            if (sub.charAt(i) == '0') idx++;
            else return sub.substring(idx, sub.length());
        }

        return "0";
    }
}
