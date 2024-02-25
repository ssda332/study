package com.algorithm.baaarkingdog;

import java.util.*;
import java.io.*;

public class BOJ18108_1998년생인_내가_태국에서는_2541년생 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A == 0 && B == 0) break;

            sb.append(A + B).append("\n");
        }

        System.out.println(sb);

    }
}
