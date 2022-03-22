package com.cjs.homeworkOJ.test;

public class Demo2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode endNode = null;

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m==n) return head;
        ListNode oriHead = head;
        ListNode priHead = head;
        int k = m;
        while (m > 1) {
            priHead = head;
            head = head.next;
            m--;
        }

        n = n - k;
        ListNode node = subReverse(head, n);
        if (k == 1) return node;
        priHead.next = node;

        return oriHead;
    }

    public static ListNode subReverse(ListNode head, int len) {
        if (len == 0) {
            endNode = head.next;
            return head;
        }

        ListNode newHead = subReverse(head.next, len - 1);

        head.next.next = head;
        head.next = endNode;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode listNode = reverseBetween(node, 3, 4);

        while (listNode!=null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
