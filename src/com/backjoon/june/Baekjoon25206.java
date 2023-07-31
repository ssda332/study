package com.backjoon.june;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon25206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> score = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            score.add(sc.nextLine());
        }

        double creditSum = score.stream()
                .mapToDouble(data -> {
                    String[] dataArr = data.split(" ");
                    if (dataArr[2].equals("P")) return 0.0;
                    return Double.parseDouble(dataArr[1]);
                }).sum();

        double creditPlusPointSum = score.stream()
                .mapToDouble(data -> {
                    String[] dataArr = data.split(" ");
                    if (dataArr[2].equals("P") || dataArr[2].equals("F")) return 0.0;
                    double result = Double.parseDouble(dataArr[1]) * Double.parseDouble(calculate(dataArr[2]));
                    return result;
                }).sum();

        if (creditPlusPointSum == 0) {
            System.out.println(0.000000);
        }else {
            System.out.println(String.format("%.6f", creditPlusPointSum / creditSum));
        }


    }

    public static String calculate(String score) {
        score = score.replace("A", "4");
        score = score.replace("B", "3");
        score = score.replace("C", "2");
        score = score.replace("D", "1");
        score = score.replace("+", ".5");
        score = score.replace("0", ".0");
        return score;
    }
}
