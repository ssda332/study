package com.test;

public class GcdLcm {
    public static void main(String[] args) {
        System.out.println(GCD(6, 30));
    }

    public int solution(int slice, int n) {
        return LCM(slice, n) / slice;
    }

    public static int GCD(int n, int slice) {
        if(slice == 0) return n;
        return GCD(slice, n % slice);
    }

    public static int LCM(int slice, int n) {
        return n * slice / GCD(n, slice);
    }
}
