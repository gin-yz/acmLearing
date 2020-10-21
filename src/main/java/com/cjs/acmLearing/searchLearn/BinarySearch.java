package com.cjs.acmLearing.searchLearn;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random(428);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        //二分查找先需要排序
        shell(arr);
        System.out.println(Arrays.toString(arr));
//        int index = binarySearch(arr, 77, 0, arr.length - 1);
        int index = binarySearch(arr, 77);
        System.out.println(index);
    }

    /**
     * 递归实现
     *
     * @param arr
     * @param value
     * @param left
     * @param right
     * @return
     */
    private static int binarySearch(int[] arr, int value, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (value > arr[mid]) return binarySearch(arr, value, mid + 1, right); //带返回值的递归，调用时加上return
        else if (value < arr[mid]) return binarySearch(arr, value, left, mid - 1);
        else return mid;
    }

    /**
     * 非递归实现
     *
     * @param arr
     * @param value
     * @return
     */
    private static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (value > arr[mid]) left = mid + 1;
            else if (value < arr[mid]) right = mid - 1;
            else return mid;
        }
        return -1;
    }

    private static void shell(int[] arr) {
        for (int i = arr.length / 2; i > 0; i /= 2) {
            for (int j = i; j < arr.length; j += 1) {
                int value = arr[j];
                int k = j - i;
                while (k >= 0 && value < arr[k]) {
                    arr[k + i] = arr[k];
                    k -= i;
                }
                arr[k + i] = value;
            }

        }
    }

}
