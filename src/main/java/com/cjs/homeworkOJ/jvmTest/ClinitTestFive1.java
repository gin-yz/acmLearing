package com.cjs.homeworkOJ.jvmTest;

/**
 * @author jinsheng
 * @date 2021年10月25日 15:45
 */
public class ClinitTestFive1 {

    private static ClinitTestFive1 test;

    static {
        test = new ClinitTestFive1();
    }

    private static final String name = new String("string_name");

    private String testName;

    private ClinitTestFive1() {
        testName = name;
    }

    public static void main(String[] args) {
        System.out.println(test.testName); // 输出结果为: null
    }
}