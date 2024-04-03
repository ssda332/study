package com.algorithm.baaarkingdog.chapter1;

import java.util.*;
import java.io.*;

public class TEST3 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        System.out.println(Math.abs(N - M));

    }
}