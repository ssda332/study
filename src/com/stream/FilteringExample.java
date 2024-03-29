package com.stream;

import java.util.Arrays;
import java.util.List;

public class FilteringExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("홍길동", "신용권", "감자바", "신용권", "신민철", "홍길동", "김영진", "감자바");

        names.stream()
                .forEach(System.out::println);

        System.out.println("-----------");

        names.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("-----------");

        names.stream()
                .distinct()
                .filter(n -> n.startsWith("신"))
                .forEach(System.out::println);
    }
}
