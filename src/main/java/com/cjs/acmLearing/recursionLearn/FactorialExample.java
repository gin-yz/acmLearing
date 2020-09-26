package com.cjs.acmLearing.recursionLearn;

public class FactorialExample {
    public static void main(String[] args) {
        System.out.println(factorial(3));
    }

    public static int factorial(int num) {
        if (num == 1) {
            return num;
        } else {
            return factorial(num - 1) * num;
        }
    }
}
