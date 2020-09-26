package com.cjs.acmLearing.testExample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FullDPDemo {
    public static void main(String[] args) {
        int[] w = {2, 3, 4};
        int[] val = {2, 3, 4};
        int n = w.length;
        int m = 10;

        int[][] v = new int[n + 1][m + 1];
        int[][] path = new int[n + 1][m + 1];

        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }

        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k <= m / w[i - 1]; k++) {
                    if (k * w[i - 1] <= j) {
                        v[i][j] = Math.max(v[i][j], v[i - 1][j - k * w[i - 1]] + k * val[i - 1]);
                        if (v[i - 1][j - k * w[i - 1]] + k * val[i - 1] > v[i - 1][j]) path[i][j] = k;
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

        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0) {
            if (path[i][j] != 0) {
                System.out.println("选择的物品编号是：" + i + "件数是：" + path[i][j]);
                j = j - path[i][j]*w[i - 1];
            }
            i--;
        }
    }
}
