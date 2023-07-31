package com.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ToListExample {
    public static void main(String[] args) {

        List<StudentDetail> totalList = Arrays.asList(
                new StudentDetail("홍길동", 10, StudentDetail.Sex.MALE),
                new StudentDetail("김수애", 6, StudentDetail.Sex.FEMALE),
                new StudentDetail("신용권", 10, StudentDetail.Sex.MALE),
                new StudentDetail("박수미", 6, StudentDetail.Sex.FEMALE)
        );

        totalList.forEach(s -> System.out.println(s.getName()));

        //남학생들만 묶어 List 생성
        List<StudentDetail> maleList = totalList.stream()
                .filter(studentDetail -> studentDetail.getSex() == StudentDetail.Sex.MALE)
                .collect(Collectors.toList());

        maleList.forEach(System.out::println);
/*

        maleList.stream()
                .map(s -> s.getName())
                .forEach(System.out::println);
*/

        System.out.println();

        //여학생들만 묶어 HashSet 생성
        Set<StudentDetail> femaleSet = totalList.stream()
                .filter(s -> s.getSex() == StudentDetail.Sex.FEMALE)
                .collect(Collectors.toCollection(HashSet::new));

        femaleSet.stream()
                .map(s -> s.getName())
                .forEach(System.out::println);
    }
}
