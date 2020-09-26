package com.cjs.acmLearing.divideAndConquer;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HanoitowerDemo {
    public static void main(String[] args) {
        int n = 10;
        List<Integer> inputList = IntStream.range(0,n).boxed().collect(Collectors.toList());

    }

}

