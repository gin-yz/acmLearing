package com.cjs.acmLearing.sortLearn;

import java.util.Arrays;
import java.util.Random;

public class ShellSort {
    public static void main(String[] args) {
        int[] randNums = new int[100];
        Random random = new Random();
        for (int i = 0; i < randNums.length; i++) {
            randNums[i] = random.nextInt(100);
        }
        shell(randNums);

        System.out.println(Arrays.toString(randNums));

    }

    public static void shell(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {  //先确定间隔
            for (int i = gap; i < arr.length; i++) { //每个小组内进行插入排序,间隔为ｇａｐ
                int index = i - gap;
                int insertVal = arr[i];
                while (index >= 0 && insertVal < arr[index]) {
                    arr[index + gap] = arr[index];
                    index -= gap;
                }
                if (index + gap != i) arr[index + gap] = insertVal;
            }
        }

    }

}
