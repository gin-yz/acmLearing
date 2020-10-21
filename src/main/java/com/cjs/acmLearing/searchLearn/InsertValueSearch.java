/*
 * 插值查找，二分查找的改进
 * 每次不在取中间的值了，而是根据value的值看是靠近left还是right
 * */

package com.cjs.acmLearing.searchLearn;

import java.util.Arrays;
import java.util.Random;

public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random(428);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int index = binarySearch(arr, 77, 0, arr.length - 1);
        int index2 = binarySearch(arr, 77);
        System.out.println(index);
        System.out.println(index2);
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
        if (left > right || value < arr[left] || value > arr[right]) return -1;
        int mid = left + (value - arr[left]) * (right - left) / (arr[right] - arr[left]); //value值的若过大或过小，会使得mid的值过大或过小，造成越界,顾在上式中要加上判断条件
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
        while (left < right || value > arr[left] || value < arr[right]) {
            int mid = left + (value - arr[left]) * (right - left) / (arr[right] - arr[left]);
            if (value > arr[mid]) left = mid + 1;
            else if (value < arr[mid]) right = mid - 1;
            else return mid;
        }
        return -1;
    }
}
