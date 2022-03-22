package com.cjs.homeworkOJ;


import java.util.Arrays;

public class FourTesst {
    public static int[] findScope(int[] array, int target) {
        int[] result = {-1, -1};
        //先判断，若比最小的小，比最大的大，则（－１，－１）
        if (target < array[0] || target > array[array.length - 1]) return result;
        int left = 0;
        int right = array.length - 1;
        //二分法
        while (left +1 < right) {
            int midIndex = left + (right - left) / 2;
            if (array[midIndex] >= target) right = midIndex;
            else left = midIndex;
        }
        result[0] = array[right] == target ? right : -1;
        left = right;
        right = array.length - 1;

        while (left +1 < right) {
            int midIndex = left + (right - left) / 2;
            if (array[midIndex] <= target) left = midIndex;
            else right = midIndex;
        }
        result[1] = array[left] == target ? left : -1;
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 8, 8, 8, 10};
        int[] ints = findScope(arr, 7);

        System.out.println(Arrays.toString(ints));
    }

}

