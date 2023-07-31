package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Baekjoon1744_수_묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQ = new PriorityQueue<>();
        int zero = 0;
        int one = 0;

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input > 1) {
                plusQ.add(input);
            }else if (input == 1) {
                one++;
            }else if (input == 0) {
                zero++;
            }else {
                minusQ.add(input);
            }
        }

        int sum = 0;
        while (!minusQ.isEmpty()) {
            if (minusQ.size() == 1) {
                int poll = minusQ.poll();
                if (zero == 0) {
                    sum += poll;
                }
                break;
            }

            int num1 = minusQ.poll();
            int num2 = minusQ.poll();
            sum += num1 * num2;
        }

        while (!plusQ.isEmpty()) {
            if (plusQ.size() == 1) {
                sum += plusQ.poll();
                break;
            }

            int num1 = plusQ.poll();
            int num2 = plusQ.poll();
            sum += num1 * num2;
        }

        sum += one;

        System.out.println(sum);
    }
}
