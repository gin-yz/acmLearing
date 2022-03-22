package com.cjs.homeworkOJ.test2;


import com.cjs.homeworkOJ.test.TreeHelper;
import com.cjs.homeworkOJ.test.TreeNode;

/**
 * @author jinsheng
 * @date 2021年12月14日 22:46
 */
public class Demo4 {

    TreeNode fatherNode;
    TreeNode currentNode;
    boolean isBalance = false;
    boolean isLeft = false;
    TreeNode root;
    public TreeNode balanceBST(TreeNode root) {
        this.root = root;
        while(!isBalance){
            isBalance = true;
            fatherNode = null;
            currentNode = null;
            dfs(null,this.root);
            if(!isBalance){
                judgeAVL();
            }
        }
        return this.root;
    }

    private int dfs(TreeNode faNode,TreeNode node){
        if(!isBalance) return 0;
        if(node==null) return 0;
        fatherNode = node;
        int leftDepth = dfs(node,node.left);
        int rightDepth = dfs(node,node.right);
        if(Math.abs(leftDepth-rightDepth)>1){
            currentNode = node;
            fatherNode = faNode;
            isBalance = false;
            if(leftDepth>rightDepth) isLeft = true;
            else isLeft = false;
            return 0;
        }
        if(leftDepth>rightDepth) return leftDepth+1;
        else return rightDepth+1;
    }

    private void judgeAVL(){
        if(isLeft){
            TreeNode leftNode = currentNode.left;
            if(fatherNode!=null){
                if(fatherNode.left == currentNode){
                    fatherNode.left = leftNode;
                }else{
                    fatherNode.right = leftNode;
                }
            }
            TreeNode leftNodeRight = leftNode.right;
            leftNode.right = currentNode;
            currentNode.left = leftNodeRight;
            if(root==currentNode){
                root = leftNode;
            }
        }else{
            TreeNode rightNode = currentNode.right;
            if(fatherNode!=null){
                if(fatherNode.left == currentNode){
                    fatherNode.left = rightNode;
                }else{
                    fatherNode.right = rightNode;
                }
            }
            TreeNode rightNodeLeft = rightNode.left;
            rightNode.left = currentNode;
            currentNode.right = rightNodeLeft;
            if(root==currentNode){
                root = rightNode;
            }
        }
    }

    public static void main(String[] args) {
        Demo4 demo4 = new Demo4();
        TreeNode treeNode1 = TreeHelper.initTree(new Integer[]{3,1,null,null,2});
        TreeNode treeNode = demo4.balanceBST(treeNode1);

        System.out.println(treeNode);
    }
}
