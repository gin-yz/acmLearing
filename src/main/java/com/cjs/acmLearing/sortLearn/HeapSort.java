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
//        for (int num = arr.length; num > 1; num--) { //后面的都排好序后，最后一个不需要排了
//            for (int i = num / 2 - 1; i >= 0; i--) { //找到最后一个非叶子结点
//                int maxSubNodeIndex = findMaxSubNodeIndex(arr, i, num); //比较非叶子节点子结点的大小，返回最大的一个的标志，若无右结点，直接返回左结点
//                if (maxSubNodeIndex == 0) { //将返回最大结点同父结点进行比较，若大于父结点，进行交换
//                    if (arr[i * 2 + 1] > arr[i]) swap(arr, i * 2 + 1, i);
//                } else {
//                    if (arr[i * 2 + 2] > arr[i]) swap(arr, i * 2 + 2, i);
//                }
//            }

//            swap(arr, 0, num - 1); //此时，根结点最大，将其与现在的尾结点进行交换
//
//        }

        for (int i = arr.length / 2 - 1; i >= 0; i--) { //先将其变成一个大顶堆
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, j,0);//交换根结点和动态的最后一个元素
            adjustHeap(arr, 0, j);//调整树，使得重新成为ｉ一个大顶堆
        }
    }

//    //比较非叶子节点子结点的大小，返回最大的一个的标志，若无右结点，直接返回左结点
//    //返回0是左结点，１是右结点
//    private static int findMaxSubNodeIndex(int[] arr, int index, int num) {
//        if (index * 2 + 2 < num) {
//            if (arr[index * 2 + 1] > arr[index * 2 + 2]) return 0;
//            else return 1;
//        } else return 0;
//    }

    //老师的方法，经典一些
    private static void adjustHeapTeacher(int[] arr, int index, int len) {
        int temp = arr[index];
        for (int i = index * 2 + 1; i < len; i = i * 2 + 1) {
            if (i + 1 < len && arr[i] < arr[i + 1]) i++;//找出左右子结点更大的下标
            if (temp < arr[i]) {//目前的根结点和子结点最大的值比较
                arr[index] = arr[i]; //将目前的根结点赋值最大值
                index = i;//记录一下目前沉底的下标，
            }else break;
        }
        arr[index] = temp;//将最终沉底的变量赋值这个子树的根
    }
    //我写的，好理解
    private static void adjustHeap(int[] arr, int index, int len) {
        for (int i = index * 2 + 1; i < len; i = i * 2 + 1) {
            if (i + 1 < len && arr[i] < arr[i + 1]) i++;//找出左右子结点更大的下标
            if (arr[index] < arr[i]) {//目前的根结点和子结点最大的值比较
                swap(arr,index,i);
                index = i;//迭代，只对调整过的子树进行改变.
            }else break; //说明根结点比子结点都小，无需调整
        }
    }
    private static void swap(int[] arr, int a,int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
