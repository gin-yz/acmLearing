package com.cjs.acmLearing.testExample;

import java.util.Arrays;
import java.util.Random;

public class TestHeapSort {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random(428);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

        heapSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    private static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) adjust(arr, i, arr.length);

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, i, 0);
            adjust(arr, 0, i);
        }
    }

    private static void adjust(int[] arr, int index, int length) {
        int i = index * 2 + 1;
        if (i + 1 < length && arr[i + 1] > arr[i]) i++;
        if (i < length && arr[index] < arr[i]) {
            swap(arr, index, i);
            adjust(arr, i, length);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
