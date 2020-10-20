/*
 * 基数排序
 *
 * */

package com.cjs.acmLearing.sortLearn;

import java.util.Arrays;
import java.util.Random;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }
        System.out.println(Arrays.toString(arr));


        radixSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        int[][] bucket = new int[10][arr.length]; //弄十个桶，０~９
        int[] bucketNum = new int[10]; //记录每个桶放的数量

        int maxValue = maxValue(arr); //遍历出最大的值
        for (int i = 1; maxValue / i > 0; i *= 10) { //根据最大的值的位数，决定遍历的次数
            for (int value : arr) { //将数组放置桶内
                int suffix = (value / i) % 10; //取第ｉ位，注意不是value%10,因为当ｉ＝１００时，ｖalue=3时，要得到０
                bucket[suffix][bucketNum[suffix]] = value;
                bucketNum[suffix] += 1;
            }

            int k = 0;
            for (int m = 0; m < bucketNum.length; m++) { //将桶中的数放至数组中，进行下一次遍历
                for (int n = 0; n < bucketNum[m]; n++) {
                    arr[k++] = bucket[m][n];
                }
                bucketNum[m] = 0;
            }
        }
    }

    private static int maxValue(int[] arr) { //取最大值
        int max = arr[0];
        for (int i : arr) {
            if (i > max) max = i;
        }
        return max;
    }
}
