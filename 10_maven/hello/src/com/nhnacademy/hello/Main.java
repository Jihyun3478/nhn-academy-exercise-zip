package com.nhnacademy.hello;

import com.nhnacademy.hello.util.Calculator;

public class Main {
    public static void main(String[] args) {
        int a = 100;
        int b = 10;

        System.out.println("더하기:" + Calculator.plus(a, b));
        System.out.println("배기:" + Calculator.subtract(a, b));
        System.out.println("나누기:" + Calculator.divide(a, b));
        System.out.println("곱하기:" + Calculator.multiply(a, b));
    }
}
