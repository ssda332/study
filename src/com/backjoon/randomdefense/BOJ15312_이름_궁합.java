package com.backjoon.randomdefense;

import java.io.*;

public class BOJ15312_이름_궁합 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        int[] match = new int[A.length() + B.length()];

        int[] alpha = new int[] {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        int idx = 0;
        for (int i = 1; i < match.length; i+=2) {

            match[i - 1] = alpha[A.charAt(idx) - 'A'];
            match[i] = alpha[B.charAt(idx) - 'A'];

            idx++;
            if (idx == A.length()) break;
        }

        int size = match.length;
        while (size > 2) {
            for (int i = 0; i < size - 1; i++) {
                match[i] = (match[i] + match[i + 1]) % 10;
            }
            match[--size] = 0;
        }

        System.out.print(match[0]);
        System.out.print(match[1]);


    }
}
