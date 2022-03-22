package com.cjs.homeworkOJ.finalAns2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Two {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        if (nums.length == 0) {
            return res;
        }
        //先对数组排序
        Arrays.sort(nums);
        //定义辅助数组
        //dp[i]:到第i个位置LargestDivisibleSubset的长度
        //状态转移方程：if(nums[i] % nums[j] == 0 && dp[i] < dp[j]+1) dp[i] = dp[j]+1
        //pre[i]指向第i个元素的被除数的索引
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(pre, -1);
        int max = 0;
        int maxid = 0;//首先将maxid随意指向一个元素
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;//更新dp[i]
                    pre[i] = j;       //更新pre[i]
                    if (dp[i] > max) {
                        max = dp[i];//更新最大长度
                        maxid = i;  //更新最大长度对应的索引
                    }
                }
            }
        }
        while (maxid != -1) {
            res.add(nums[maxid]);
            maxid = pre[maxid];
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = largestDivisibleSubset(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        System.out.println(list);
    }

}
