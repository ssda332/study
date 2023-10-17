package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ2630_색종이_만들기 {

    static int N;
    static int[][] A;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cutting(0, N, 0, N);

        System.out.println(white);
        System.out.println(blue);


    }

    static void cutting(int startX, int endX, int startY, int endY) {
        int temp = A[startY][startX];
        boolean flag = false;

        for (int i = startY; i < endY; i++) {
            for (int j = startX; j < endX; j++) {
                if (temp != A[i][j]) {
                    flag = true;
                }
            }
        }

        if (flag) {
            cutting(startX, (startX + endX) / 2, startY, (startY + endY) / 2); // 1사분면
            cutting((startX + endX) / 2, endX, startY, (startY + endY) / 2); // 2사분면
            cutting(startX, (startX + endX) / 2, (startY + endY) / 2, endY); // 3사분면
            cutting((startX + endX) / 2, endX, (startY + endY) / 2, endY); // 4사분면
        } else {
            if (temp == 0) white++;
            else if (temp == 1) blue++;
        }
    }
}
