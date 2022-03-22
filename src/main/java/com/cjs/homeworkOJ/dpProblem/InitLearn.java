package com.cjs.homeworkOJ.dpProblem;

import java.util.Arrays;
import java.util.function.Consumer;

public class InitLearn {
    static final int MAX = 1000;

    public static void main(String[] args) {
//        InitLearn initLearn = new InitLearn();
//        System.out.println(initLearn.f(27));

        dpF(27, new int[]{2, 5, 7});

//        dpRun(10, 10);

//        dpJump(new int[]{3, 2, 1, 0, 4});


//        int[] w = {1, 4, 3};
//        int[] val = {1500, 3000, 2000};
//        fullBK(new int[]{1, 4, 3}, new int[]{1500, 3000, 2000}, 4);

//        zeroOneBK(new int[]{1, 4, 3}, new int[]{1500, 3000, 2000}, 4);

//        mutilBK(new int[]{3, 4, 5}, new int[]{2, 3, 4}, new int[]{4, 3, 2}, 15);
    }

    public int f(int X) {
        if (X == 0) return 0;
        int res = MAX;
        if (X >= 2) res = Math.min(f(X - 2) + 1, res);
        if (X >= 5) res = Math.min(f(X - 5) + 1, res);
        if (X >= 7) res = Math.min(f(X - 7) + 1, res);
        return res;
    }

    //分钱
    public static void dpF(int X, int[] coins) {
        int[] dp = new int[X + 1];
        for (int i = 1; i <= X; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }

        System.out.println(dp[X]);
        System.out.println(Arrays.toString(dp));
    }

    //走格子
    public static void dpRun(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        Arrays.stream(dp).forEach(new Consumer<int[]>() {
            @Override
            public void accept(int[] ints) {
                System.out.println(Arrays.toString(ints));
            }
        });
    }

    //跳跃问题[2,3,1,1,4],[3,2,1,0,4]
    public static void dpJump(int[] weigth) {
        boolean[] dp = new boolean[weigth.length];
        dp[0] = true;
        for (int i = 1; i < weigth.length; i++) {
            dp[i] = false;
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + weigth[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(dp));

    }

    //完全背包
    public static void fullBK(int[] weight, int[] value, int volume) {
        int[] dp = new int[volume + 1];
        dp[0] = 0;
        for (int i = 1; i <= volume; i++) {
            dp[i] = 0;
            for (int j = 0; j < weight.length; j++) {
                if (i >= weight[j]) {
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
    }

    //0-1背包
    public static void zeroOneBK(int[] weight, int[] value, int volume) {
        int[] dp = new int[volume + 1];
        dp[0] = 0;
        for (int i = 0; i < weight.length; i++) {
            for (int j = volume; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        System.out.println(Arrays.toString(dp));
    }

    //多重背包
    public static void mutilBK(int[] weight, int[] value, int[] count, int volume) {
        int[] dp = new int[volume + 1];
        dp[0] = 0;
        for (int i = 0; i < weight.length; i++) {
            for (int j = volume; j >= weight[i]; j--) {
                for (int k = 1; k <= Math.min(count[i], j / weight[i]); k++) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }

        System.out.println(Arrays.toString(dp));
    }

}
