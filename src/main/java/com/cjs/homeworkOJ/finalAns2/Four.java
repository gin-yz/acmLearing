package com.cjs.homeworkOJ.finalAns2;

import java.util.Arrays;

import static java.lang.Math.min;

public class Four {
    public static int Dp(int[] weight){
        int m = weight.length;
        int[] v = new int[m + 1];
        Arrays.fill(v, m);
        v[0] = 0;
        for (int i = 1; i <= weight.length; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k <= m / weight[i - 1]; k++) {
                    if (k * weight[i - 1] <= j) {
                        v[j] = min(v[j], v[j - k * weight[i - 1]] + k);
                    }
                }
            }
        }
        return v[v.length-1];
    }
}
