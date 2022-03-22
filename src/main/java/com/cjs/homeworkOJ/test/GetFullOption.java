package com.cjs.homeworkOJ.test;

import java.util.*;
import java.util.stream.Collectors;

//得到所有满足小于等于W的wi的最大取值的排列组合
public class GetFullOption {
    public static void main(String[] args) {
        int[] wi = new int[]{4, 6, 8}; //顾客期望，假设是2，4，6，8
        int W = 20; //W的大小，假设是20
        int[] track = new int[wi.length]; //追踪的辅助数组
        Arrays.sort(wi); //将wi数组排序方便遍历。
        dfs(wi, W, track); //使用dfs遍历输出全部符合要求的排列组合
        System.out.println(res); //打印结果
    }

    private static final Set<List<Integer>> res = new HashSet<>(); //追踪记录答案

    /**
     * @param nums  原始数组
     * @param limit 限制大小
     * @param track 追踪记录数组
     */
    public static void dfs(int[] nums, int limit, int[] track) {
        int currentValue = getCurrentValue(nums, track); //目前的值
        //若目前的值刚好满足小于W，且无法再容纳任何一个wi
        if (currentValue + nums[0] > limit && currentValue <= limit) {
            List<Integer> list = Arrays.stream(track).boxed().collect(Collectors.toList());
            res.add(list); //记录一个选择
            return;
        }

        //回溯法遍历
        for (int i = 0; i < nums.length; i++) {
            if (getCurrentValue(nums, track) > limit) return; //剪枝
            track[i] += 1;
            dfs(nums, limit, track);
            track[i] -= 1;
        }
    }

    //得到目前的累加值
    public static int getCurrentValue(int[] nums, int[] track) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] * track[i];
        }
        return sum;
    }
}
