package com.cjs.homeworkOJ.test4;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jinsheng
 * @date 2022年02月22日 16:53
 */
public class Demo5 {
    public int longestValidParentheses(String s) {
        char[] array = s.toCharArray();
        LinkedList<Integer> indexList = new LinkedList<>();
        int maxLen = 0;
        for (int i = 0; i < array.length; i++) {
            if (!indexList.isEmpty() && array[indexList.peekLast()] == '(' && array[i] == ')') {
                indexList.pollLast();
            } else {
                indexList.addLast(i);
            }
            maxLen = Math.max(maxLen, i - (indexList.isEmpty() ? -1 : indexList.peekLast()));
        }
        return maxLen;
    }

    public static void main(String[] args) {


    }
}

class CJS {
    private String name;
    private int age;
    private String school;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CJS)) return false;

        CJS cjs = (CJS) o;

        if (age != cjs.age) return false;
        if (!name.equals(cjs.name)) return false;
        return school.equals(cjs.school);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + school.hashCode();
        return result;
    }
}