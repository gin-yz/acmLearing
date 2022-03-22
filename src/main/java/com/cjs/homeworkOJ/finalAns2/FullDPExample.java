package com.cjs.homeworkOJ.finalAns2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

import static java.lang.Math.min;

public class FullDPExample {
    public static void main(String[] args) {
        int[] w = {1, 5, 7};
        int m = 10; //背包容量

        int[] v = new int[m + 1];
        Arrays.fill(v, m);
        v[0] = 0;

        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k <= m / w[i - 1]; k++) {
                    if (k * w[i - 1] <= j) {
                        v[j] = min(v[j], v[j - k * w[i - 1]] + k);
                    }
                }
            }
        }

        int[] dp = new int[m + 1];
        Arrays.fill(dp, m);
        dp[0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int k : w) {
                if (k <= i) {
                    dp[i] = min(dp[i], dp[i - k] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
//        Arrays.stream(v).map(new Function<int[], List<Integer>>() {
//            @Override
//            public List<Integer> apply(int[] ints) {
//                return Arrays.stream(ints).boxed().collect(Collectors.toList());
//            }
//        }).forEach(System.out::println);

        List<Integer> l = Arrays.stream(v).boxed().collect(Collectors.toList());
        System.out.println(l);
//        int i = v.length - 1;
//        int j = v[0].length - 1;
//        while (i > 0 && j > 0) {
//            if (path[i][j] != 0) {
//                System.out.printf("放入的物品ｉｄ为：%s,放入了：%s个%n", i,path[i][j]);
//                j -= path[i][j]*w[i - 1];
//            }
//            i--;
//        }

        int[] w2 ={1,2,3,4,5,6,7,8,9};
        int[] dp2 = new int[w2.length];
        List<Integer> temp = new ArrayList<>();
        int sum = Arrays.stream(w2).reduce(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        }).getAsInt();
        Arrays.fill(dp2, sum);

        for (int i = 0; i < dp2.length; i++) {
            dp2[i] = Math.min(dp2[i], Math.abs(dp2[i] - w2[i]));

            if (Math.abs(dp2[i] - w2[i])<dp2[i]) temp.add(w2[i]);

        }
        System.out.println(temp);
        System.out.println(Arrays.toString(dp2));


    }
}
