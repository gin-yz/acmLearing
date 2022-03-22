package com.cjs.acmLearing.sortLearn;

import java.util.Arrays;
import java.util.Random;


/**
 * @author jinsheng
 * @date 2022年02月28日 23:32
 */
public class HeapSortSmall {

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random(428);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));

        heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(i, arr, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(0, i, arr);
            adjustHeap(0, arr, i);
        }
    }


    private static void adjustHeap(int startIndex, int[] arr, int length) {
        for (int index = startIndex * 2 + 1; index < length; index = startIndex * 2 + 1) {
            if (index + 1 < length && arr[index] < arr[index + 1]) index++;
            if (arr[startIndex] < arr[index]) {
                swap(startIndex,index,arr);
                startIndex = index;
            }else {
                break;
            }
        }
    }

    private static void swap(int index1, int index2, int[] arr) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
