package com.backjoon.greedy;

import java.io.*;
import java.util.*;

public class BOJ1459_걷기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken()); // 한 블록
        long S = Long.parseLong(st.nextToken()); // 대각선
        // 0,0 출발

        if (W * 2 <= S) {
            System.out.println(X * W + Y * W);
        } else { // 대각선 이동할 경우의수
            long max = Math.max(X, Y);
            long min = Math.min(X, Y);

            if (X == 0 || Y == 0) { // 지그재그 이동만 가능
                long num = max % 2;

                System.out.println((max - num) * S + num * W);
            } else { // 대각선으로 쭉 가는것도 필요할 경우
                long minus = max - min;
                long num = minus % 2;
                if (W >= S) { // 지그재그보다 그냥 가는게 더 빠른경우
                    System.out.println(min * S + (minus - num) * S + num * W);
                } else {
                    System.out.println(min * S + minus * W);
                }
            }


        }

    }
}
