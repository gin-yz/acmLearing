package com.cjs.acmLearing.dataStrcuturesLearn.TreeLearn.selfBinaryTreeLearn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class BinaryTreeNoRe {

    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void preOrderNoRE(TreeNode startNode) {
        LinkedList<TreeNode> tmpTreeNodes = new LinkedList<>();
        while (startNode != null || !tmpTreeNodes.isEmpty()) {
            while (startNode != null) {
                System.out.println(startNode);
                tmpTreeNodes.push(startNode);
                startNode = startNode.getLeft();
            }
            if (!tmpTreeNodes.isEmpty()) {
                startNode = tmpTreeNodes.poll();
                startNode = startNode.getRight();
            }
        }
    }

    public void midOrderNoRE(TreeNode startNode) {
        LinkedList<TreeNode> tmpTreeNodes = new LinkedList<>();
        while (startNode != null || !tmpTreeNodes.isEmpty()) {
            while (startNode != null) {
                tmpTreeNodes.push(startNode);
                startNode = startNode.getLeft();
            }
            if (!tmpTreeNodes.isEmpty()) {
                startNode = tmpTreeNodes.poll();
                System.out.println(startNode);
                startNode = startNode.getRight();
            }
        }
    }

    public void postOrderNoRE(TreeNode startNode) {
        LinkedList<TreeNode> tmpTreeNodes = new LinkedList<>();
        //标志位栈
        LinkedList<Integer> isVisited = new LinkedList<>();
        //左右标志
        int left = 0;
        int right = 1;
        while (startNode != null || !tmpTreeNodes.isEmpty()) {
            while (startNode != null) {
                tmpTreeNodes.push(startNode);
                isVisited.push(left);
                startNode = startNode.getLeft();
            }

            while (!tmpTreeNodes.isEmpty() && isVisited.peek() == right) {
                //标志位清除
                isVisited.poll();
                //弹出结点
                System.out.println(tmpTreeNodes.poll());
            }

            if (!tmpTreeNodes.isEmpty() && isVisited.peek() == left) {
                //换标志位
                isVisited.poll();
                isVisited.push(right);
                //取右子树
                startNode = tmpTreeNodes.peek().getRight();
            }
        }
    }

    public void treeBFS(){
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addLast(getRoot());
        while (!linkedList.isEmpty()){
            TreeNode treeNode = linkedList.removeFirst();
            System.out.println(treeNode);
            if (treeNode.getLeft()!=null) linkedList.addLast(treeNode.getLeft());
            if (treeNode.getRight()!=null) linkedList.addLast(treeNode.getRight());
        }
    }
}
