package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ5525_IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        int[] memo = new int[M];
        int result = 0;

        for (int i = 2; i < s.length; i++) {
            if (s[i - 2] == 'I' && s[i - 1] == 'O' && s[i] == 'I') memo[i] = memo[i - 2] + 1;
            if (N <= memo[i]) result++;
        }

        System.out.println(result);

    }
}
