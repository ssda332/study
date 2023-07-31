package com.generic;

import java.io.InputStream;
import java.util.Scanner;

public class BoundedTypeParameterExample {
    public static void main(String[] args) {
//        Util.compare("a", "b");

        Scanner sc = new Scanner(System.in);
        System.out.print("int : ");
        int i = sc.nextInt();

        int compare = Util.compare(55, 30);
        System.out.println("compare = " + compare);
    }
}
