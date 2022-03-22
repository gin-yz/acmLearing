package com.cjs.homeworkOJ.finalAns3;

import java.util.Arrays;

public class Six {
    public static int minTime(int[] cows){
        //找寻最小过河时间的牛
        int minCow = Integer.MAX_VALUE;
        for (int cow : cows) {
            if (minCow>cow) minCow = cow;
        }
        //返回时间
        return Arrays.stream(cows).sum()+cows.length*minCow;
    }
}
