package com.algorithm.baaarkingdog.chapter1;

import java.util.*;
import java.io.*;

public class TEST3 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < R; j++) {
                    sb.append(str.charAt(i));
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}