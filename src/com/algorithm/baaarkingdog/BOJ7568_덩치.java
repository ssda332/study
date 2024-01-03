package com.algorithm.baaarkingdog;

import java.io.*;
import java.util.*;

public class BOJ7568_덩치 {

    static class Person {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Person[] list = new Person[N];
        int[] rank = new int[N];

        Arrays.fill(rank, 1);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            list[i] = new Person(height, weight);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Person p1 = list[i];
                Person p2 = list[j];

                if (i == j) continue;
                if (p1.height < p2.height && p1.weight < p2.weight) rank[i]++;
            }
        }

        Arrays.stream(rank).forEach(s -> {
            System.out.println(s + " ");
        });



    }
}
