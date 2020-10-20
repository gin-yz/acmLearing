package com.cjs.homeworkOJ.homeworkDemo;

import java.util.Scanner;

public class ThreeDigitsTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.next());
        int b = Integer.parseInt(scanner.next());
        int result = 1;
        for (int i = 0; i < b; i++) {
            result = (result*a)%1000;
        }
        System.out.println(result);
    }
}
