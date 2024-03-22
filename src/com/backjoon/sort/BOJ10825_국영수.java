package com.backjoon.sort;

import java.io.*;
import java.util.*;

public class BOJ10825_국영수 {

    static class Student implements Comparable<Student>{
        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (this.kor == o.kor) {
                if (this.eng == o.eng) {
                    if (this.math == o.math) {
                        return (this.name.compareTo(o.name));
                    }

                    return Integer.compare(o.math, this.math);
                }

                return Integer.compare(this.eng, o.eng);
            }
            return Integer.compare(o.kor, this.kor);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Student> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            list.add(new Student(name, kor, eng, math));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        list.stream()
                .forEach(student -> {
                    sb.append(student.name).append("\n");
                });

        System.out.println(sb);
    }
}
