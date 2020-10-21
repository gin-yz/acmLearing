package com.cjs.acmLearing.testExample;

import java.util.Arrays;
import java.util.Random;

public class TestHeapSort {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random(500);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

        heapSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    private static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i > 0; i--) {
            adjust(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjust(arr, 0, i);
        }
    }

    private static void adjust(int[] arr, int index, int length) {
//        int temp = arr[index];
        while (index<length){
            if (index*2+1<length){
                if (index*2+2<length && arr[index*2+1]<arr[index*2+2]){

                }
            }
        }
    }
}
