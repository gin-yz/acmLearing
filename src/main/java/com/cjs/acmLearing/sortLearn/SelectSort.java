/*
* 遍历，每次选最小的元素，放至前排末尾
* */
package com.cjs.acmLearing.sortLearn;

import java.util.Arrays;
import java.util.Random;

public class SelectSort {
    public static void main(String[] args) {
        int[] randNums = new int[10];
        Random random = new Random();
        for (int i = 0; i < randNums.length; i++) {
            randNums[i] = random.nextInt(10);
        }
        select(randNums);
        System.out.println(Arrays.toString(randNums));
    }

    public static void select(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minNum = arr[i];
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minNum) {
                    minIndex = j;
                    minNum = arr[j];
                }
            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = minNum;
            }

        }
    }
}
