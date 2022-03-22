package com.cjs.homeworkOJ.test;

import java.util.TreeSet;

public class Demo3 {
    public void flatten(TreeNode root) {
        f(root);
    }

    public static TreeNode f(TreeNode root) {
        if (root == null) return null;
        TreeNode left = null;
        TreeNode right = null;
        if (root.left != null) {
            left = f(root.left);
        }
        if (root.right != null) {
            right = f(root.right);
        }
        if (left != null) {
            root.right = left;
            root.left = null;
            while (left.right != null) {
                left = left.right;
            }
            if (right != null) {
                left.right = right;
            }
        }

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        node2.right = node6;
        TreeNode node1 = new TreeNode(2, node3, node4);
        TreeNode node = new TreeNode(1, node1, node2);
        f(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.right;
        }
    }

}
