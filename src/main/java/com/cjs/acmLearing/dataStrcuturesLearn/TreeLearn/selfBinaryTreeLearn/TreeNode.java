package com.cjs.acmLearing.dataStrcuturesLearn.TreeLearn.selfBinaryTreeLearn;

class TreeNode {
    private int no;
    private String data;
    private TreeNode left = null;
    private TreeNode right = null;

    public TreeNode(int no, String data) {
        this.no = no;
        this.data = data;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode:" +
                "no=" + no +
                ", data='" + data;
    }
}
