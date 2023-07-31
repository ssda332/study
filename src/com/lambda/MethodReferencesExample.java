package com.lambda;

import java.util.function.IntBinaryOperator;

public class MethodReferencesExample {
    public static void main(String[] args) {
        IntBinaryOperator operator;

        //정적 메소드 참조
        operator = Calculator::staticMethod;

        System.out.println("결과 : " + operator.applyAsInt(3, 4));

        Calculator calculator = new Calculator();
        operator = calculator :: instanceMethod;

        System.out.println("결과2 : " + operator.applyAsInt(5, 6));
    }
}
