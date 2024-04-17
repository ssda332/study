package com.algorithm.baaarkingdog.chapter1;

import java.util.*;
import java.io.*;

public class 연습장4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        System.out.println((N / 2L) * M + (N % 2L) * (M / 2L));

    }
}
