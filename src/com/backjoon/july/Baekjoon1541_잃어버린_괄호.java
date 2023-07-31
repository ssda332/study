package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1541_잃어버린_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, "+-", true);

        int sum = 0;
        int minus = 0;
        boolean flag = false;
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            if (!token.equals("+") && !token.equals("-")) {
                if (flag) {
                    minus += Integer.parseInt(token);
                }else {
                    sum += Integer.parseInt(token);
                }
            }

            if (token.equals("-")) {
                sum -= minus;
                minus = 0;
                flag = true;
            }
        }

        System.out.println(sum - minus);
    }
}
