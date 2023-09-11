package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1780_종이의_개수 {

    static int zero = 0;
    static int minus = 0;
    static int plus = 0;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(N, 0, 0);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);

    }

    static void cut(int n, int x, int y) {
        int temp = A[y][x];
        int num = n / 3;
        boolean flag = false;

//        System.out.println("n : " + n + ", x : " + x + ", y : " + y + ", n + y : " + (n + y) + ", n + x : " + (n + x));

        for (int i = y; i < n + y; i++) {
            for (int j = x; j < n + x ; j++) {
                if (temp != A[i][j]) {
//                    System.out.println("A[" + i + "][" + j + "] : " + A[i][j] + ", temp : " + temp);
                    cut(num, x, y);
                    cut(num, x + num, y);
                    cut(num, x + (num * 2), y);
                    cut(num, x, y + num);
                    cut(num, x + num, y + num);
                    cut(num, x + (num * 2), y + num);
                    cut(num, x, y + (num * 2));
                    cut(num, x + num, y + (num * 2));
                    cut(num, x + (num * 2), y + (num * 2));
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        if (!flag) {
            if (temp == 0) {
                zero += 1;
            } else if (temp == -1) {
                minus += 1;
            } else {
                plus += 1;
            }
        }
    }
}
