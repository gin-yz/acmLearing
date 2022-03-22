package com.cjs.homeworkOJ.test;

public class Demo1 {
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

    public static ListNode mergeKLists(ListNode[] lists) {
        return divideConquer(lists, 0, lists.length - 1);
    }

    public static ListNode divideConquer(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];

        int mid = left + (right - left) / 2;
        ListNode leftNode = divideConquer(lists, left, mid);
        ListNode rightNode = divideConquer(lists, mid+1, right);

        ListNode minList = new ListNode(0);
        ListNode tail = minList;

        while (leftNode != null && rightNode != null) {
            if (leftNode.val < rightNode.val) {
                tail.next = leftNode;
                leftNode = leftNode.next;
                tail = tail.next;
                tail.next = null;
            } else {
                tail.next = rightNode;
                rightNode = rightNode.next;
                tail = tail.next;
                tail.next = null;
            }
        }
        if (leftNode == null && rightNode != null) {
            tail.next = rightNode;
        }else tail.next = leftNode;

        return minList.next;
    }


    public static void main(String[] args) {
//        [[1,4,5],[1,3,4],[2,6]]
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        node.next = node1;
        node1.next = node2;

        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        node3.next = node4;
        node4.next = node5;

        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(6);
        node6.next = node7;

        ListNode[] listNodes = new ListNode[]{node,node3,node6};

        ListNode node8 = mergeKLists(listNodes);

        while (node8!=null){
            System.out.println(node8.val);
            node8 = node8.next;
        }
    }
}
