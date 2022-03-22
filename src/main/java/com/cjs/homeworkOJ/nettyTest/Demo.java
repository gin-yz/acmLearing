package com.cjs.homeworkOJ.nettyTest;

import java.util.*;

/**
 * @author jinsheng
 * @date 2021年11月12日 10:21
 */
public class Demo {

    public static int[] searchRange(int[] nums, int target) {
        if(nums ==null||nums.length==0) return new int[]{-1,-1};
        int[] res = new int[]{-1,-1};
        int left = 0;
        int right = nums.length;
        //左移
        while(left<right){
            int halfIndex = left + (right-left)/2;
            if(nums[halfIndex]>target){
                right = halfIndex;
            }else if(nums[halfIndex]<target){
                left = halfIndex+1;
            }else{
                right = halfIndex;
            }
        }

        if(left>=nums.length||nums[left]!=target){
            return res;
        }
        res[0] = left;

        right = nums.length;

        while(left<right){
            int halfIndex = left+ (right-left)/2;
            if(nums[halfIndex]>target){
                right = halfIndex;
            }else if(nums[halfIndex]<target){
                left = halfIndex+1;
            }else{
                left = halfIndex+1;
            }
        }

        res[1] = left;
        return res;
    }

    public static void main(String[] args) {
        int[] ints = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);


    }
}