package com.backjoon.string;

import java.io.*;
import java.util.*;

public class BOJ1120_문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= B.length() - A.length(); i++) {
            String sub = B.substring(i, i + A.length());
            int result = 0;

            for (int j = 0; j < sub.length(); j++) {
                if (A.charAt(j) != sub.charAt(j)) result++;
            }

            if (answer > result) answer = result;
        }

        System.out.println(answer);
    }

}
