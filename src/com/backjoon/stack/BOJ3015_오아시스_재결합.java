package com.backjoon.stack;

import java.io.*;
import java.util.*;

public class BOJ3015_오아시스_재결합 {

    static int answer = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        /**
        * 서로 볼수 있는 쌍의 개수니깐, top이 작을때 pop을 해주는데 이때 count하지 않는다.
         * 같을 경우에만 count해준다(서로 볼수 있단 뜻)
        * */


        int N = getInteger();
        Stack<Person> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int height = getInteger();
            Person person = new Person(height, 1);

            while (!stack.isEmpty() && stack.peek().height <= height) {
                Person pop = stack.pop();
                answer += pop.count;
                if (pop.height == height) {
                    person.count += pop.count;
                }

            }

            if (!stack.isEmpty()) {
                answer++;
            }

            stack.push(person);

        }

        System.out.println(answer);
    }

    private static int getInteger() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static class Person {
        public int height;
        public int count;

        public Person(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }
}
