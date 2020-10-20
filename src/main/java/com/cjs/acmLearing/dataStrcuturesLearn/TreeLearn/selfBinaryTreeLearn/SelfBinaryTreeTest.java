package com.cjs.acmLearing.dataStrcuturesLearn.TreeLearn.selfBinaryTreeLearn;

import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SelfBinaryTreeTest {
    public static void main(String[] args) {
        List<TreeNode> treeNodes = IntStream.range(0, 11).mapToObj(new IntFunction<TreeNode>() {
            @Override
            public TreeNode apply(int value) {
                return new TreeNode(value, "Node,no:" + value);
            }
        }).collect(Collectors.toList());

        for (int i = 0; i < treeNodes.size(); i++) {
            if (2 * i + 1 < treeNodes.size() && treeNodes.get(2 * i + 1) != null)
                treeNodes.get(i).setLeft(treeNodes.get(2 * i + 1));
            if (2 * i + 2 < treeNodes.size() && treeNodes.get(2 * i + 2) != null)
                treeNodes.get(i).setRight(treeNodes.get(2 * i + 2));
        }

        TreeNode treeNode11 = new TreeNode(11, "Node,no:11");
        TreeNode treeNode12 = new TreeNode(12, "Node,no:12");
        treeNodes.get(5).setRight(treeNode11);
        treeNodes.get(6).setLeft(treeNode12);

        BinaryTreeRe binaryTreeRe = new BinaryTreeRe();
        binaryTreeRe.setRoot(treeNodes.get(0));

        System.out.println("前序遍历");
        binaryTreeRe.preOrderRE(treeNodes.get(0));
        System.out.println("中序遍历");
        binaryTreeRe.midOrderRE(treeNodes.get(0));
        System.out.println("后序遍历");
        binaryTreeRe.postOrderRE(treeNodes.get(0));

        BinaryTreeNoRe binaryTreeNoRe = new BinaryTreeNoRe();
        binaryTreeNoRe.setRoot(treeNodes.get(0));

        System.out.println("前序非递归遍历");
        binaryTreeNoRe.preOrderNoRE(treeNodes.get(0));
        System.out.println("中序非递归遍历");
        binaryTreeNoRe.midOrderNoRE(treeNodes.get(0));
        System.out.println("后序非递归遍历");
        binaryTreeNoRe.postOrderNoRE(treeNodes.get(0));
        System.out.println("层次遍历");
        binaryTreeNoRe.treeBFS();

    }
}

