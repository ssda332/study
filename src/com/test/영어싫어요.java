package com.test;

public class 영어싫어요 {
    public static void main(String[] args) {
        String numbers = "one two threefourfivesixseveneightnine";

        numbers.replace('o', 'q');
        numbers.replace("one", "1");
        numbers.replace("two", "2");
        numbers.replace("three", "3");
        numbers.replace("four", "4");
        numbers.replace("five", "5");
        numbers.replace("six", "6");
        numbers.replace("seven", "7");
        numbers.replace("eight", "8");
        numbers.replace("nine", "9");

        System.out.println(numbers);

    }
}
