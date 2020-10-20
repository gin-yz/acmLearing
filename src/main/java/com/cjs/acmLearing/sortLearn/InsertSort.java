package com.cjs.acmLearing.sortLearn;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
//        int[] randNums = new int[10];
//        Random random = new Random();
//        for (int i = 0; i < randNums.length; i++) {
//            randNums[i] = random.nextInt(10);
//        }

        int[] randNums = {9, 8, 7, 6, 5, 4, 3, 2, 1};


        insert(randNums);

        System.out.println(Arrays.toString(randNums));
    }

    public static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int index = i - 1;
            int insertVal = arr[i];

            while (index >= 0 && insertVal < arr[index]) { //前面的都是排好的，比较一下插入到哪里，并将后面的值进行移位
                arr[index + 1] = arr[index];
                index--;
            }

            if (index + 1 != i) arr[index + 1] = insertVal;

        }
    }


}
