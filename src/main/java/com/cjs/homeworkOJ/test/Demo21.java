package com.cjs.homeworkOJ.test;

import java.util.*;

/**
 * @author jinsheng
 * @date 2021年10月26日 18:47
 */
public class Demo21 {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    ;

    public Node flatten(Node head) {
        recusiveNode(head);
        return head;
    }

    private Node recusiveNode(Node node) {
        if (node == null) return null;
        if (node.child != null) {
            Node next = node.next;
            node.next = node.child;
            node.child.prev = node;
            Node nodeTail = recusiveNode(node.child);
            nodeTail.next = next;
            node.child = null;
            if (next != null) {
                next.prev = nodeTail;
                node = next;
            }else return nodeTail;
        }
        if (node.next == null) return node;
        else return recusiveNode(node.next);
    }

    public static void main(String[] args) {

        Node node = new Node();
        node.val = 1;
        Node node2 = new Node();
        node2.val = 2;
        node.next = node2;
        node2.prev = node;
        Node node3 = new Node();
        node3.val = 3;
        node2.next = node3;
        node3.prev = node2;
        Node node4 = new Node();
        node4.val = 4;
        node4.prev = node3;
        node3.next = node4;
        Node node5 = new Node();
        node5.val = 5;
        node4.next = node5;
        node5.prev = node4;
        Node node6 = new Node();
        node6.val = 6;
        node5.next = node6;
        node6.prev = node5;

        Node node7 = new Node();
        node7.val = 7;
        Node node8 = new Node();
        node8.val = 8;
        Node node9 = new Node();
        node9.val = 9;
        Node node10 = new Node();
        node10.val = 10;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.prev = node9;
        node9.prev = node8;
        node8.prev = node7;

        node3.child = node7;

        Node node11 = new Node();
        node11.val = 11;
        Node node12 = new Node();
        node12.val = 12;

        node11.next = node12;
        node12.prev = node11;

        node8.child = node11;

        Demo21 demo21 = new Demo21();

        Node node51 = new Node();
        Node node52 = new Node();
        Node node53 = new Node();
        node51.val = 1;
        node52.val = 2;
        node53.val = 3;
        node51.child = node52;
        node52.child = node53;
        Node flatten = demo21.flatten(node51);

        System.out.println(flatten);

    }
}
