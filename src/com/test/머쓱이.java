package com.test;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

public class 머쓱이 {

    public static void main(String[] args) {

        System.out.println(pactorial(27));

    }

    public static BigInteger pactorial(int num) {
        if(num > 1) {
            return pactorial(num - 1).multiply(new BigInteger("" + num));
        }else {
            return BigInteger.ONE;
        }
    }
}
