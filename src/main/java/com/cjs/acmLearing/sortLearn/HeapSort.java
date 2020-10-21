/*
 * 堆排序，通过完全二叉树的思想进行调整
 *  */
package com.cjs.acmLearing.sortLearn;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random(428);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20);
        }
        System.out.println(Arrays.toString(arr));

        heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        for (int num = arr.length; num > 1; num--) { //后面的都排好序后，最后一个不需要排了
            for (int i = num / 2 - 1; i >= 0; i--) { //找到最后一个非叶子结点
                int maxSubNodeIndex = findMaxSubNodeIndex(arr, i, num); //比较非叶子节点子结点的大小，返回最大的一个的标志，若无右结点，直接返回左结点
                if (maxSubNodeIndex == 0) { //将返回最大结点同父结点进行比较，若大于父结点，进行交换
                    if (arr[i * 2 + 1] > arr[i]) swap(arr, i * 2 + 1, i);
                } else {
                    if (arr[i * 2 + 2] > arr[i]) swap(arr, i * 2 + 2, i);
                }
            }

            swap(arr, 0, num - 1); //此时，根结点最大，将其与现在的尾结点进行交换

        }
    }

    private static void swap(int[] arr, int sub, int index) {
        int temp = arr[sub];
        arr[sub] = arr[index];
        arr[index] = temp;
    }

    //比较非叶子节点子结点的大小，返回最大的一个的标志，若无右结点，直接返回左结点
    //返回0是左结点，１是右结点
    private static int findMaxSubNodeIndex(int[] arr, int index, int num) {
        if (index * 2 + 2 < num) {
            if (arr[index * 2 + 1] > arr[index * 2 + 2]) return 0;
            else return 1;
        } else return 0;
    }

}
