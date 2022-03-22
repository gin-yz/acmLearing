package com.cjs.homeworkOJ.finalAns3;

import java.util.Arrays;

public class Three {


    public static int minBoat(int[] weight, int maxWeight) {
        int boatNum = 0; //船数量
        //将体重排序
        Arrays.sort(weight);
        int left = 0;
        int right = weight.length - 1;
        while (left <= right) {
            //将只能做一个船的人计算
            while (left <= right && weight[left] + weight[right] > maxWeight) {
                right--;
                boatNum++;
            }
            //两个人合伙搭船
            if (left<=right){
                left++;
                right--;
                boatNum++;
            }
        }
        return boatNum;
    }
}
