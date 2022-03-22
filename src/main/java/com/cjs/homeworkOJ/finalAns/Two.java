package com.cjs.homeworkOJ.finalAns;

public class Two {
    public static int findTreeLocalMinValue(Node node) {
        //若右子树不为空，且右子树的值小于根的值，那么递归右节点的子树
        if (node.rightNode != null && node.rightNode.value < node.value) return findTreeLocalMinValue(node.rightNode);
        //同理，对左子树也是相同操作
        else if (node.leftNode != null && node.leftNode.value < node.value) return findTreeLocalMinValue(node.leftNode);
        //不然返回根节点对应下标
        else return node.no;
    }
}

class Node {
    public int no; //下标
    public int value;//值
    public Node leftNode;//左节点
    public Node rightNode;//右节点
}
