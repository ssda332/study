package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ2480_주사위_세개 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());

        if (X == Y && Y == Z) System.out.println(10000 + (X * 1000));
        else if (X != Y && Y != Z && X != Z) System.out.println(Math.max(Math.max(X, Y), Z) * 100);
        else {
            if (X == Y) System.out.println(1000 + X * 100);
            else System.out.println(1000 + Z * 100);
        }
    }
}
