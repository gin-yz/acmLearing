package com.cjs.acmLearing.DPLearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ZeroOneDPExample {
    public static void main(String[] args) {

        int[] w = {1, 4, 3};
        int[] val = {1500, 3000, 2000};

        int n = val.length; //商品数量
        int m = 4; //背包容量

        int[][] v = new int[n + 1][m + 1];
        int[][] path = new int[n + 1][m + 1]; //记录放入的商品


        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        for (int j = 0; j < v.length; j++) {
            v[j][0] = 0;
        }

        List<Integer> sum_list = new ArrayList<>();
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                if (j < w[i - 1]) v[i][j] = v[i - 1][j];
                else {
                    v[i][j] = Math.max(v[i - 1][j], v[i - 1][j - w[i - 1]] + val[i - 1]);
                    if ((v[i - 1][j - w[i - 1]] + val[i - 1]) > v[i - 1][j]) path[i][j] = 1;
                }
            }

        }

        var list = Arrays.stream(v).map(new Function<int[], List<Integer>>() {
            @Override
            public List<Integer> apply(int[] ints) {
                return Arrays.asList(Arrays.stream(ints).boxed().toArray(Integer[]::new));
            }
        }).collect(Collectors.toList());

        list.forEach(System.out::println);

        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("放入了第：%s商品%n", i);
                j -= w[i - 1];
            }
            i--;
        }
    }

}
