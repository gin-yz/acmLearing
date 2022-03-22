package com.cjs.acmLearing.testExample;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();

        TreeNode treeNode = test.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});

//        int max = test.findMax(new int[]{1, 20, 30, 4, 5}, 0, 4);
//        System.out.println(max);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return f(nums,0,nums.length-1);
    }

    public TreeNode f(int[] arr,int left,int right){
        if (right<left){
            return null;
        }
        if(left == right){
            return new TreeNode(arr[left]);
        }

        int maxIndex = findMax(arr,left,right);

        TreeNode node = new TreeNode(arr[maxIndex]);

        node.left = f(arr,left,maxIndex-1);
        node.right = f(arr,maxIndex+1,right);

        return node;
    }

    public int findMax(int[] arr,int left,int right){
        int max = arr[left];
        int maxIndex = left;
        for(int i = left;i<=right;i++){
            if(max<arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}