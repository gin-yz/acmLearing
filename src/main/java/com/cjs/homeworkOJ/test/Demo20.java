package com.cjs.homeworkOJ.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author jinsheng
 * @date 2021年10月25日 23:04
 */
public class Demo20 {
    int totalMaxValue = 0;
    class ResClz{
        Integer sum;
        Integer value;
    }
    public int maxSumBST(TreeNode root) {
        ResClz leftRes = recusiveBstTree(root.left,0);
        ResClz rightRes = recusiveBstTree(root.right,1);
        if(leftRes==null||rightRes==null) return totalMaxValue;
        if(root.val<rightRes.value&&root.val>leftRes.value){
            boolean tmpRes = true;
            if(root.right!=null&&root.val>root.right.val) tmpRes=false;
            if(root.left!=null&&root.val<root.left.val) tmpRes=false;
            if(tmpRes){
                int total = leftRes.sum + rightRes.sum + root.val;
                totalMaxValue = Math.max(totalMaxValue,total);
            }
        }
        return totalMaxValue;
    }

    private ResClz recusiveBstTree(TreeNode node,int signal){
        if(node==null) {
            ResClz resClz = new ResClz();
            resClz.sum = 0;
            if(signal == 0){
                resClz.value = Integer.MIN_VALUE;
            }else{
                resClz.value = Integer.MAX_VALUE;
            }
            return resClz;
        }
        ResClz leftRes = recusiveBstTree(node.left,0);
        ResClz rightRes = recusiveBstTree(node.right,1);
        // if(node.left==null&&node.right==null){

        //     totalMaxValue = Math.max(totalMaxValue,node.val);
        // }
        if(leftRes==null||rightRes==null) return null;
        if(node.val<rightRes.value&&node.val>leftRes.value){
            boolean tmpRes = true;
            if(node.right!=null&&node.val>node.right.val) tmpRes=false;
            if(node.left!=null&&node.val<node.left.val) tmpRes=false;
            if(tmpRes){
                int total = leftRes.sum + rightRes.sum + node.val;
                totalMaxValue = Math.max(totalMaxValue,total);
                if(signal==0){
                    leftRes.sum = total;
                    leftRes.value = Math.max(leftRes.value,node.val);
                    return leftRes;
                }else{
                    rightRes.sum = total;
                    rightRes.value = Math.min(rightRes.value,node.val);
                    return rightRes;
                }
            }else return null;
        }else return null;
    }
    public static void main(String[] args) {
//        Demo20 demo20 = new Demo20();
//
//        TreeNode treeNode = TreeHelper.initTree(new Integer[]{1, null, 10, -5, 20});
//
//        int i = demo20.maxSumBST(treeNode);
//
//        System.out.println(treeNode);
        LinkedList<Integer> tmpList = new LinkedList<>(List.of(1,2,3,4,5,6));
        Integer first = tmpList.removeFirst();
        System.out.println(tmpList);
        System.out.println(first);

        StringBuilder sb = new StringBuilder();

//        sb.append(String.valueOf(null));

        System.out.println(sb.toString());

        String s = "1,1,1,";

        String[] split = s.split(",");

        System.out.println(split);

    }
}
