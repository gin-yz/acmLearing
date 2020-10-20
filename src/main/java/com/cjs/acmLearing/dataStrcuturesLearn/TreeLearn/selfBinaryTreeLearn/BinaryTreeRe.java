/*
* 二叉数递归实现
* */

package com.cjs.acmLearing.dataStrcuturesLearn.TreeLearn.selfBinaryTreeLearn;


class BinaryTreeRe {
    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }


    //递归实现
    public void preOrderRE(TreeNode startNode) {
//        if (startNode == null) return;
        System.out.println(startNode);
        if (startNode.getLeft() != null) preOrderRE(startNode.getLeft());
        if (startNode.getRight() != null) preOrderRE(startNode.getRight());
    }

    public void midOrderRE(TreeNode startNode) {
//        if (startNode == null) return;
        if (startNode.getLeft() != null) midOrderRE(startNode.getLeft());
        System.out.println(startNode);
        if (startNode.getRight() != null) midOrderRE(startNode.getRight());
    }

    public void postOrderRE(TreeNode startNode) {
//        if (startNode == null) return;
        if (startNode.getLeft() != null) postOrderRE(startNode.getLeft());
        if (startNode.getRight() != null) postOrderRE(startNode.getRight());
        System.out.println(startNode);
    }
}
