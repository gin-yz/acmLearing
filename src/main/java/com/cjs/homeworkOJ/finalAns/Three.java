package com.cjs.homeworkOJ.finalAns;

import java.util.Arrays;
import java.util.Random;

public class Three {
    public static int findMaxSub(int[] array, int left, int right) {
        if (left == right) return array[left];
        int mid = (left + right) / 2;
        int leftMax = findMaxSub(array, left, mid);
        int rightMax = findMaxSub(array, mid + 1, right);
        int midMax = findMidMax(array, left, mid, right);
        //返回左,右,和起来最大的
        return Math.max(Math.max(leftMax, rightMax), midMax);
    }

    private static int findMidMax(int[] array, int left, int mid, int right) {
        int i = mid;
        int j = mid + 1;
        int leftAjMaxSum = Integer.MIN_VALUE;
        int rightAjMaxSum = Integer.MIN_VALUE;
        int tempSum = 0;
        //从右至左找左边的，挨着的最大和
        while (i >= left) {
            tempSum += array[i];
            if (tempSum > leftAjMaxSum) {
                leftAjMaxSum = tempSum;
            }
            i--;
        }
        tempSum = 0;
        //从左至右找右边的，挨着的最大和
        while (j <= right) {
            tempSum += array[j];
            if (tempSum > rightAjMaxSum) {
                rightAjMaxSum = tempSum;
            }
            j++;
        }
        //两边最大相和
        return leftAjMaxSum+rightAjMaxSum;
    }
    public static void main(String[] args) {
//        int[] arr = new int[10];
//        Random random = new Random();
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = random.nextInt(100)-50;
//        }

        int[] arr ={-10,-20};
        System.out.println(Arrays.toString(arr));

        int maxSub = findMaxSub(arr, 0, arr.length - 1);

        System.out.println(maxSub);
    }
}
