package com.cjs.homeworkOJ.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Demo7 {
    public static void main(String[] args) {
        int[] arr = new int[10];

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        int[] arr2 = new int[10];

        List<Integer> list2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());


//        System.out.println(list);
    }
}
