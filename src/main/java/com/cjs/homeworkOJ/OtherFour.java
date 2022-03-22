package com.cjs.homeworkOJ;

import java.util.Arrays;

public class OtherFour {
    public static int[] searchRange(int[] nums, int target) {
        int[] pos = {-1, -1};
        if(nums == null || nums.length == 0){
            return pos;
        }
        int L = 0;
        int R = nums.length - 1;
        while (L <= R) {
            int mid = L + ((R - L) >>> 1);

            if (nums[mid] < target) {
                L = mid + 1;
            } else
                R = mid - 1;
        }
        pos[0] = L < nums.length && nums[L] == target ? L : -1;   //注意索引越界判断
        //System.out.println("第一次出现的位置：" + pos[0]);
        if (pos[0] == -1){
            return pos;
        }
        R = nums.length - 1;
        while(L <= R){
            int mid = L + ((R - L) >>> 1);
            if (nums[mid] <= target){
                L = mid + 1;
            }else
                R = mid - 1;
        }
        pos[1] = R >= 0 && nums[R] == target ? R : -1;    //注意索引越界判断
        //System.out.println("最后一次出现的位置：" + pos[1]);
        return pos;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,8,8,8,10};
        int[] ints = searchRange(arr, 8);

        System.out.println(Arrays.toString(ints));

    }
}
