package com.cjs.homeworkOJ.jvmTest;

/**
 * @author jinsheng
 * @date 2021年10月25日 15:45
 */
public class ClinitTestFive {
    private static ClinitTestFive test;

    static {
        test = new ClinitTestFive();
    }

    private static final String name = "string_name";

    private String testName;

    private ClinitTestFive() {
        testName = name;
    }


    public static void main(String[] args) {
//        System.out.println(test.testName); // 输出结果为: string_name
    }
}
