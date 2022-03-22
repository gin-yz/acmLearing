/*
* 快排简单实现
* */
package com.cjs.acmLearing.sortLearn;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] randNums = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        quickSort(randNums, 0, randNums.length-1);

        System.out.println(Arrays.toString(randNums));
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int pivot = getPartition(arr, l, r); //找出中心点（随便选），然后将比中心点小放左边，比中心点大的放右边

            quickSort(arr, l, pivot - 1); //左边再排
            quickSort(arr, pivot + 1, r); //右边再排
        }
    }

    private static int getPartition(int[] arr, int l, int r) {
        int pivotKey = arr[l];

        while (l < r) {
            while (l < r && pivotKey <= arr[r]) r--;
            if(l<r) swap(arr, l, r);
            while (l < r && pivotKey >= arr[l]) l++;
            if(l<r) swap(arr, l, r);
        }

        return l;//这个时候l==r,返回什么都可以
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
