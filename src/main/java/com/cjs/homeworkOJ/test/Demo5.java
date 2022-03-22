package com.cjs.homeworkOJ.test;

import com.cjs.acmLearing.sortLearn.SelectSort;

public class Demo5 {
    public static int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        int max = weights[0];
        for(int weight:weights){
            sum+=weight;
            if (max<weight) max = weight;
        }
        int left = max;
        int right = sum+1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(D-getSumDays(weights,mid)>=0) right = mid;
            else left = mid+1;
        }
        return left;
    }

    public static int getSumDays(int[] weights, int len){
        int sum = 0;
        int day = 0;
        for(int i = 0;i<weights.length;i++){
            sum +=weights[i];
            if(sum > len){
                sum = 0;
                i--;
                day++;
            }

            if(sum == len){
                sum =0;
                day++;
            }
        }
        return sum>0?++day:day;
    }

    public static void main(String[] args) {
        int i = shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 1);
        System.out.println(i);
//        System.out.println(getSumDays(new int[]{1,2,3,1,1}, 3));
    }
}
