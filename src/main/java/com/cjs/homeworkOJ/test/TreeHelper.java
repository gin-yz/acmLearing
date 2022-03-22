package com.cjs.homeworkOJ.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jinsheng
 * @date 2021年10月22日 18:42
 */
public class TreeHelper {
    public static TreeNode initTree(Integer[] vals) {
        TreeNode root = new TreeNode(vals[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        int cur = 1;
        queue.offer(root);
        while (queue != null) {
            TreeNode r = queue.poll();
            if (vals[cur] == null) {
                r.left=null;
            } else {
                r.left = new TreeNode(vals[cur]);
                queue.offer(r.left);
            }
            if (++cur >= vals.length) {
                break;
            }
            if (vals[cur] == null) {
                r.right = null;
            } else {
                r.right = new TreeNode(vals[cur]);
                queue.offer(r.right);
            }
            if (++cur >= vals.length) {
                break;
            }
        }
        return root;
    }
}
