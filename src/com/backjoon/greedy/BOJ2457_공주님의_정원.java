package com.backjoon.greedy;

import java.io.*;
import java.util.*;

public class BOJ2457_공주님의_정원 {

    static class Flower {
        public int start;
        public int end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Flower{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Flower> flowers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());

            flowers.add(new Flower(start, end));
        }

        Collections.sort(flowers, new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                if (o1.start == o2.start) return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });

//        flowers.stream().forEach(System.out::println);
//        System.out.println("----------------");

        int startDate = 301;
        int endDate = 1130;
        int max = 0;
        int count = 0;

        for (int i = 0; i < flowers.size(); i++) {
            Flower flower = flowers.get(i);

            if (flower.start > startDate) {

                if (max < flower.start) {
                    System.out.println(0);
                    return;
                }

                if (max <= startDate) { // 두 조건을 만족하는 꽃들을 선택할 수 없다면
                    System.out.println(0);
                    return;
                } else { // 조건을 만족하고 이전 꽃과 연결할 수 있다면
                    count++;
                    startDate = max;
                    max = flower.end;

                    if (flower.end > endDate) {
                        count++;
                        System.out.println(count);
                        return;
                    }
                }
            } else {
                if (flower.end > endDate) {
                    count++;
                    System.out.println(count);
                    return;
                }

                if (flower.end > max) {
                    max = flower.end;
                }
            }

//            System.out.println(flower + ", count : " + count);
        }

        System.out.println(0);

    }

}
