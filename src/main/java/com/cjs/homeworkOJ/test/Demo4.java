package com.cjs.homeworkOJ.test;

import java.util.*;

public class Demo4 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    public static Node connect(Node root) {
        if(root.left==null ||root.right == null) return null;
        if(root.left!=null) root.left.next = root.right;
        if(root.next!=null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        Node connect = connect(null);

    }

}
