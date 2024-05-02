package com.algorithm.baaarkingdog.chapter1;

import java.io.*;
import java.util.StringTokenizer;

public class TEST3 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.println((parseInt(st.nextToken()) * parseInt(st.nextToken())) + (parseInt(st.nextToken()) * parseInt(st.nextToken())));
    }

    static Integer parseInt(String str) {
        return Integer.parseInt(str);
    }
}