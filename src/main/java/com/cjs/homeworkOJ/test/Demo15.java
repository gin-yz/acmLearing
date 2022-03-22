package com.cjs.homeworkOJ.test;

/**
 * @author jinsheng
 * @date 2021年10月18日 15:29
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jinsheng
 * @date 2021年10月17日 21:13
 */
public class Demo15 {

    private static List<List<Integer>> finalList = new ArrayList<>();
    private static LinkedList<Integer> tmpList = new LinkedList<>();
    public static List<List<Integer>> permute(int[] nums) {
        addList(nums);

        return finalList;
    }

    public static void addList(int[] nums){
        for (int num : nums) {
            if (!tmpList.contains(num)) {
                tmpList.add(num);
                if (tmpList.size() == nums.length) {
                    List<Integer> list = new ArrayList<>(tmpList.size());
                    list.addAll(tmpList);
                    finalList.add(list);
                }
                addList(nums);
                tmpList.removeLast();
            }
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> permute = permute(new int[]{1, 2, 3});

        System.out.println(permute);


    }
}

