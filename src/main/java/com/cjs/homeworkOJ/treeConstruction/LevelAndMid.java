package com.cjs.homeworkOJ.treeConstruction;

import java.util.LinkedList;

/**
 * 由层序遍历和中序遍历还原二叉树
 * @author jinsheng
 * @date 2022年03月22日 10:50
 */
public class LevelAndMid {
    public static void main(String[] args) {
        String mid = "GDHBAEICF";
        String level = "ABCDEFGHI";
        if (mid == null || level == null || mid.length() == 0 || level.length() == 0 || mid.length() != level.length()) {
            return;
        }
        Node node = buildTree(mid, level);

        System.out.println(node);
        preOrder(node);
    }

    public static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static Node buildTree(String mid, String level) {
        LinkedList<Object[]> list = new LinkedList<>();

        Node head = new Node(level.charAt(0));
        list.add(new Object[]{head, 0, level.length() - 1});
        int levelIndex = 0;
        while (!list.isEmpty()) {
            Object[] array = list.pollFirst();
            Node node = (Node) array[0];
            int left = (int) array[1];
            int right = (int) array[2];
            int midIndex = mid.indexOf(node.val);
            if (midIndex > left) {
                levelIndex++;
                Node leftNode = new Node(level.charAt(levelIndex));
                list.addLast(new Object[]{leftNode, left, midIndex - 1});
                node.left = leftNode;
            }
            if (midIndex < right) {
                levelIndex++;
                Node rightNode = new Node(level.charAt(levelIndex));
                list.addLast(new Object[]{rightNode, midIndex + 1, right});
                node.right = rightNode;
            }

        }
        return head;
    }

    static class Node {
        char val;
        Node left;
        Node right;

        public Node(char val) {
            this.val = val;
        }
    }
}
