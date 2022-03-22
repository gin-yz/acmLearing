package com.cjs.homeworkOJ.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * @author jinsheng
 * @date 2021年10月19日 21:32
 */
public class Demo18 {
//
//    public static List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> resultList = new ArrayList<>();
//        for (int i = 0; i < nums.length - 2; i++) {
//            List<List<Integer>> twoSumList = twoSum(nums, i + 1, 0 - nums[i]);
//            for (List<Integer> tmpList : twoSumList) {
//                tmpList.add(nums[i]);
//                resultList.add(tmpList);
//            }
//            while (i < nums.length - 2 && nums[i] == nums[i + 1]) i++;
//        }
//
//        return resultList;
//    }
//
//    //start包含
//    public static List<List<Integer>> twoSum(int[] nums, int start, int target) {
//        int left = start;
//        int right = nums.length - 1;
//        List<List<Integer>> resultList = new ArrayList<>();
//        while (left < right) {
//            int sumValue = nums[left] + nums[right];
//            int leftValue = nums[left];
//            int rightValue = nums[right];
//            if (sumValue == target) {
//                ArrayList<Integer> tmp = new ArrayList<>();
//                tmp.add(leftValue);
//                tmp.add(rightValue);
//                resultList.add(tmp);
//                while (left < right && leftValue == nums[left]) left++;
//                while (left < right && rightValue == nums[right]) right--;
//            } else if (sumValue < target) {
//                while (left < right && nums[left] == leftValue) left++;
//            } else {
//                while (left < right && nums[right] == rightValue) right--;
//            }
//        }
//
//        return resultList;
//    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode nextNode;

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode startHead = new ListNode(-1, head);
        ListNode p = startHead;
        while (true) {
            ListNode afterTailNode = p.next;
            ListNode subHeadNode = recusiveList(p.next, k);
            if (subHeadNode != null) {
                p.next = subHeadNode;
                afterTailNode.next = nextNode;
                p = afterTailNode;
            } else {
                break;
            }
        }

        return startHead.next;
    }


    public static ListNode recusiveList(ListNode node, int k) {
        if(node == null) return null;
        if (k == 1) {
            nextNode = node.next;
            return node;
        }

        ListNode subHead = recusiveList(node.next, k - 1);

        if (subHead != null) {
            node.next.next = node;
            node.next = null;
        }

        return subHead;
    }

    public static void main(String[] args) {
//        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
//
//        System.out.println(lists);


//        int[] array = new int[]{1,2,3,4,5};
//        int i =1;
//        array[i]=array[i++];
//        System.out.println(array[1]);
//        System.out.println(i);
//        System.out.println(array[2]);
        final ListNode[] headtmp = {new ListNode(-1)};
        final ListNode[] p = {headtmp[0]};
        Arrays.stream(new int[]{1,2,3,4,5}).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                p[0].next = new ListNode(value);
                p[0] = p[0].next;
            }
        });

        ListNode head = headtmp[0].next;

        ListNode listNode = reverseKGroup(head, 2);

        System.out.println(listNode);
    }
}