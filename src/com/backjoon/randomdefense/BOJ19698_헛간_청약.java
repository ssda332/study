package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ19698_헛간_청약 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int X = W / L;
        int Y = H / L;

        int result = X * Y;
        if (result > N) System.out.println(N);
        else System.out.println(X * Y);
    }
}
