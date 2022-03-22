package com.cjs.homeworkOJ.test3;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //T表示有T组数据
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            //n表示有n个物品
            int n = sc.nextInt();
            //t[i][0]表示第i个物品的x属性，t[i][1]表示第i个物品的y属性，
            int[][] t = new int[n][2];
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                t[j][0] = sc.nextInt();
            }
            for (int j = 0; j < n; j++) {
                t[j][1] = sc.nextInt();
            }
            //x相同的情况下y更大的排序在前面（不然的话会重复统计相同的x）
            Arrays.sort(t, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] > o2[0])
                        return 1;
                    else if (o1[0] < o2[0])
                        return -1;
                    else {
                        if (o1[1] > o2[1])
                            return -1;
                        else if (o1[1] < o2[1])
                            return 1;
                        else
                            return -1;
                    }
                }
            });

            for (int j = 0; j < n; j++) {
                nums[j] = t[j][1];
            }
            int result = longestSubArray(nums);
            System.out.println(result);

        }
    }

    public static int longestSubArray(int[] nums) {
        //tails[k] 的值代表长度为k+1子序列 的尾部元素值
        int[] tails = new int[nums.length];
        // res 为 tails当前长度
        int res = 0;
        for (int num : nums) {
            int l = 0;
            //r为数组的长度，而不是length-1，这点要注意
            int r = res;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (tails[m] < num)
                    l = m + 1;
                else
                    r = m;
            }
            tails[l] = num;
            if (r == res)
                res++;
        }
        return res;
    }
}

