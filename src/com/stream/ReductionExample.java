package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class ReductionExample {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동", 90),
                new Student("김갑생", 92),
                new Student("김영진", 100),
                new Student("김또깡", 65),
                new Student("임예진", 84),
                new Student("강힘찬", 76),
                new Student("장덕산", 86),
                new Student("오초롱", 42)

        );

        int asInt = list.stream()
                .mapToInt(Student::getScore)
                .reduce((a, b) -> a + b)
                        .orElse(0);

        System.out.println("asInt = " + asInt);
    }
}
