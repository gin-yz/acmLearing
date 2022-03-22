package com.cjs.homeworkOJ.test3;


import java.util.HashMap;

/**
 * @author jinsheng
 * @date 2022年02月20日 19:07
 */
public class Demo1 {
    int a;
    public static void main(String[] args) {
        ThreadLocal<String> tl = new ThreadLocal<>();

        tl.set("1");
        tl.get();

    }
}
