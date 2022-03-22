package com.cjs.homeworkOJ.finalAns2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Five {
    public static void main(String[] args) {
        dp(new int[]{1,1,2,3,4});
        int[] val = {1,1,2,3,4};
        int sum = 0;
        for (int i : val) {
            sum += i;
        }

        int n = val.length; //商品数量
        int m = val.length; //背包容量

        int[][] v = new int[n + 1][sum/2 + 1];
        int[][] path = new int[n + 1][m + 1]; //记录放入的商品


        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        for (int j = 0; j < v.length; j++) {
            v[j][0] = 0;
        }

//        List<Integer> sum_list = new ArrayList<>();
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j <= sum/2; j++) {
                if (val[i - 1] <= j && Math.abs(sum - 2 * v[i - 1][j]) > Math.abs(sum - 2 * (v[i - 1][j - val[i - 1]] + val[i - 1]))) {
                    v[i][j] = v[i - 1][j - val[i - 1]] + val[i - 1];
                } else v[i][j] = v[i - 1][j];
            }
        }


        var list = Arrays.stream(v).map(new Function<int[], List<Integer>>() {
            @Override
            public List<Integer> apply(int[] ints) {
                return Arrays.asList(Arrays.stream(ints).boxed().toArray(Integer[]::new));
            }
        }).collect(Collectors.toList());

        list.forEach(System.out::println);
//
//        int i = path.length - 1;
//        int j = path[0].length - 1;
//        while (i > 0 && j > 0) {
//            if (path[i][j] == 1) {
//                System.out.printf("放入了第：%s商品%n", i);
//                j -= w[i - 1];
//            }
//            i--;
//        }
    }

    public static void dp(int[] weight) {
        int sum = 0;
        for (int i : weight) {
            sum += i;
        }

        int[] dp = new int[sum/2 + 1];

        dp[0] = 0;
        for (int i = 0; i < weight.length; i++) {
            for (int j = sum/2; j >= 1; j--) {
                if (weight[i] <= j &&Math.abs(sum - 2 * dp[j]) > Math.abs(sum - 2 * (dp[j - weight[i]] + weight[i]))) {
                    dp[j] = dp[j - weight[i]] + weight[i];
                }
            }
        }

        System.out.println(Arrays.toString(dp));
    }
}
