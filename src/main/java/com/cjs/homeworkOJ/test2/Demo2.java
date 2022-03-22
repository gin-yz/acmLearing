package com.cjs.homeworkOJ.test2;


import java.util.*;

/**
 * @author jinsheng
 * @date 2021年11月21日 10:34
 */
public class Demo2 {

    public static String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = charArray.length - 1;
        while (left < charArray.length && charArray[left] == ' ') {
            left++;
        }
        if (left >= charArray.length) return "";
        while (right >= 0 && charArray[right] == ' ') {
            right--;
        }
        if (right < 0) return "";
        int index = right;
        while (index >= left) {
            if (charArray[index] == ' ') {
                sb.append(' ');
            }
            while (index >= 0 && charArray[index] == ' ') {
                index--;
            }
            String tmpStr = "";
            while (
                    index >= 0
                            && (((charArray[index] >= 'a' && charArray[index] <= 'z')
                            || (charArray[index] >= 'A' && charArray[index] <= 'Z')
                            || (charArray[index] >= '0' && charArray[index] <= '9')))) {
                tmpStr = charArray[index] + tmpStr;
                index--;
            }
            sb.append(tmpStr);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int i = firstMissingPositive(new int[]{0, 1, 2});
        System.out.println(i);
    }

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        for(int i =0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]-1) return nums[i];
        }
        return nums[nums.length-1];
    }

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length1 = nums1.length, length2 = nums2.length;
            int totalLength = length1 + length2;
            if (totalLength % 2 == 1) {
                int midIndex = totalLength / 2;
                double median = getKthElement(nums1, nums2, midIndex + 1);
                return median;
            } else {
                int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
                double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
                return median;
            }
        }

        public int getKthElement(int[] nums1, int[] nums2, int k) {
            /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
             * 这里的 "/" 表示整除
             * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
             * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
             * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
             * 这样 pivot 本身最大也只能是第 k-1 小的元素
             * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
             * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
             * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
             */

            int length1 = nums1.length, length2 = nums2.length;
            int index1 = 0, index2 = 0;
            int kthElement = 0;

            while (true) {
                // 边界情况
                if (index1 == length1) {
                    return nums2[index2 + k - 1];
                }
                if (index2 == length2) {
                    return nums1[index1 + k - 1];
                }
                if (k == 1) {
                    return Math.min(nums1[index1], nums2[index2]);
                }

                // 正常情况
                int half = k / 2;
                int newIndex1 = Math.min(index1 + half, length1) - 1;
                int newIndex2 = Math.min(index2 + half, length2) - 1;
                int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
                if (pivot1 <= pivot2) {
                    k -= (newIndex1 - index1 + 1);
                    index1 = newIndex1 + 1;
                } else {
                    k -= (newIndex2 - index2 + 1);
                    index2 = newIndex2 + 1;
                }
            }
        }
    }

}