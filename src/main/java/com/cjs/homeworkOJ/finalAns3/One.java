package com.cjs.homeworkOJ.finalAns3;

import java.util.Arrays;

public class One {
    public static void main(String[] args) {

    }

    public static int findMinTime(int[] monkey, int[] banana) {
        //对monkey和banana排序
        Arrays.sort(monkey);
        Arrays.sort(banana);
        //求出最大间隙，为最小值
        int minTime = Integer.MIN_VALUE;
        for (int i = 0; i < monkey.length; i++) {
            int absTime = Math.abs(monkey[i] - banana[i]);
            if (minTime < absTime) minTime = absTime;
        }
        return minTime;
    }
}
