package com.cjs.acmLearing.sortLearn;

import java.util.Arrays;
import java.util.Random;

public class MergeSoft {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20);
        }
        System.out.println(Arrays.toString(arr));


        mergeSoft(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }

    private static void mergeSoft(int[] arr, int left, int right) {
        if (left < right) { //当左边比右边小的时候
            int mid = (left + right) / 2;

            mergeSoft(arr, left, mid);
            mergeSoft(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        //左和右一个一个比，赋值到新数组中
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        //将剩余为赋值的赋值
        while (i <= mid) temp[k++] = arr[i++];

        while (j <= right) temp[k++] = arr[j++];

        //将新数值中的值复制到原数组中
        for (int l = 0; l < temp.length; l++) {
            arr[left + l] = temp[l];
        }
    }

}
