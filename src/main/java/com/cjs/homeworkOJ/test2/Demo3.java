package com.cjs.homeworkOJ.test2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.*;


/**
 * @author jinsheng
 * @date 2021年12月05日 16:57
 */
public class Demo3 {
    LinkedList<Integer> tmpList;
    int[] nums;

    public int[] exchange(int[] nums) {
        if (nums.length == 0) return nums;
        this.nums = nums;
        tmpList = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            tmpList.add(nums[i]);
        }
        mergeSoft(0, nums.length - 1);
        return tmpList.stream().mapToInt(i -> i).toArray();
    }

    private int[] mergeSoft(int left, int right) {
        if (left == right) {
            if (nums[left] % 2 == 0) {
                return new int[]{left, 0, left, 1};
            } else {
                return new int[]{left, 1, left + 1, 0};
            }
        }
        int mid = left + (right - left) / 2;
        //start1,len1,start2,len2
        int[] leftResult = mergeSoft(left, mid);
        int[] rightResult = mergeSoft(mid + 1, right);
        for (int i = 0; i < leftResult[3]; i++) {
            tmpList.add(right, tmpList.remove(leftResult[2]));
        }
        return new int[]{left, leftResult[1] + rightResult[1], left + leftResult[1] + rightResult[1], leftResult[3] + rightResult[3]};
    }
    public static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        String userName = "${java:vm}";
        LOGGER.info("Hello,{}",userName);
        TreeMap<?,?> treeMap = new TreeMap<>();
        HashMap<?,?> hashMap = new HashMap<>();
    }
}
