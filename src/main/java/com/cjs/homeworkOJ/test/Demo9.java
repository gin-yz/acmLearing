package com.cjs.homeworkOJ.test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author jinsheng
 * @date 2021年10月08日 22:41
 */
public class Demo9 {
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

    static class Solution {
        int[] preorder = null;
        int[] inorder = null;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;
            return recursive(0,preorder.length-1,0,inorder.length-1);
        }

        public TreeNode recursive(int startPreorder,int endPreorder,int startInorder,int endInorder){
            if(startPreorder>=preorder.length ||startPreorder >endPreorder) return null;
            int nodeValue = preorder[startPreorder];
            int nodeIndex = returnIndex(nodeValue,startInorder,endInorder);
            TreeNode node = new TreeNode(nodeValue);
            if(startPreorder ==endPreorder ) return node;
            TreeNode leftNode = recursive(startPreorder+1,startPreorder+nodeIndex-startInorder,startInorder,nodeIndex-1);
            TreeNode rightNode = recursive(startPreorder+nodeIndex-startInorder+1,startPreorder+nodeIndex-startInorder+endInorder-nodeIndex,nodeIndex+1,endInorder);
            node.left = leftNode;
            node.right = rightNode;
            return node;
        }


        //[inoStart,inoEnd]
        public int returnIndex(int num,int inoStart,int inoEnd){
            for(int i = inoStart;i<=inoEnd;i++){
                if(num == inorder[i]) return i;
            }
            return 0;
        }
    }

    public static void main(String[] args) {

//        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
//        TreeNode root = new TreeNode(-3);
//        Solution solution = new Solution();
//
//        solution.maxPathSum(root);
//
//        System.out.println(solution.maxValue);

        IntStream.range(0, 10).boxed().collect(Collectors.toList());

//        System.out.println(array.)
        Solution solution = new Solution();
        TreeNode treeNode = solution.buildTree(new int[]{1,2}, new int[]{1,2});

        System.out.println(treeNode);
    }
}
