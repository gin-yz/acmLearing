//O(n^2)
package com.cjs.acmLearing.sortLearn;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 10);
        }

        bubble(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void bubble(int[] arr) {
        boolean isfinish = false;//若在一次比较中，无交换，则说明已经排列好
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    isfinish = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (!isfinish) break;
            else isfinish = false;
        }
    }
}
