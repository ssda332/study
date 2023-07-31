package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2343_기타_레슨 {

    /**
     * 이해가 잘 안댐 응용 안됨
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] lesson = new int[N];
        st = new StringTokenizer(br.readLine());
        int end = 0;
        int start = 0;

        for (int i = 0; i < N; i++) {
            lesson[i] = Integer.parseInt(st.nextToken());
            end += lesson[i];
            if (start < lesson[i]) {
                start = lesson[i];
            }
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;

            for (int i = 0; i < N; i++) {
                if (sum + lesson[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += lesson[i];
            }

            if (sum != 0) {
                count++;
            }
            if (count <= M) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        System.out.println(start);




    }
}
