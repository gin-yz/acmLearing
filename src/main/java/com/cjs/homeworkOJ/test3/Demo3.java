package com.cjs.homeworkOJ.test3;

import java.util.Random;

/**
 * @author jinsheng
 * @date 2022年03月04日 15:48
 */
public class Demo3 {

    public static void main(String[] args) {

    }

    class Solution {
        int[] nums;
        int k;
        Random rand;

        public int findKthLargest(int[] nums, int k) {
            this.nums = nums;
            this.k = nums.length - k;
            int resultNumber = quickSort(0, nums.length - 1);
            rand = new Random(428);
            return resultNumber;
        }

        private int quickSort(int left, int right) {
            int mid = getPartition(left, right);
            if (mid == k) return nums[k];
            if (mid > k) return quickSort(left, mid - 1);
            else return quickSort(mid + 1, right);
        }


        private int getPartition(int left, int right) {
            int index = rand.nextInt(right - left + 1) + left;
            swap(left, index);
            int key = nums[left];
            while (left < right) {
                while (left < right && nums[right] >= key) right--;
                if (left < right) swap(left, right);
                while (left < right && nums[left] <= key) left++;
                if (left < right) swap(left, right);
            }
            return left;
        }

        private void swap(int index1, int index2) {
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }
}