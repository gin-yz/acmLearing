package com.cjs.acmLearing.DPLearn;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FullDPExample {
    public static void main(String[] args) {
        int[] w = {2,3,4};
        int[] val = {2,3,4};

        int n = val.length; //商品数量
        int m = 10; //背包容量

        int[][] v = new int[n + 1][m + 1];
        int[][] path = new int[n + 1][m + 1];

        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }

        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                for (int k = 0; k <= m / w[i - 1]; k++) {
                    if (k * w[i - 1] > j) v[i][j] = v[i][j]; //若大于，后一次的值等于前一次的k*的赋值,第一次的赋值上一行的值为ｋ=0时，自动跳到else行
                    else {
                        v[i][j] = Math.max(v[i][j], v[i - 1][j - k * w[i - 1]] + k * val[i - 1]);
                        if ((v[i - 1][j - k * w[i - 1]] + k * val[i - 1]) > v[i-1][j]) path[i][j] = k;
                    }
                }
            }
        }

        Arrays.stream(v).map(new Function<int[], List<Integer>>() {
            @Override
            public List<Integer> apply(int[] ints) {
                return Arrays.stream(ints).boxed().collect(Collectors.toList());
            }
        }).forEach(System.out::println);

        int i = v.length - 1;
        int j = v[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] != 0) {
                System.out.printf("放入的物品ｉｄ为：%s,放入了：%s个%n", i,path[i][j]);
                j -= path[i][j]*w[i - 1];
            }
            i--;
        }

    }
}
