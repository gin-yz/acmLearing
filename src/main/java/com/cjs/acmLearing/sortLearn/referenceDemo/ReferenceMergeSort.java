package com.cjs.acmLearing.sortLearn.referenceDemo;

import java.util.Arrays;

public class ReferenceMergeSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
//        int[] randNums = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int l, int r) {
        int mid = (l + r) / 2;
        if (l < r) {
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            //左右归并
            merge(arr, l, mid, r);
        }
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int x = 0; x < temp.length; x++) {
            a[x + low] = temp[x];
        }
    }


}
