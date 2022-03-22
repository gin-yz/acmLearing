package com.cjs.homeworkOJ.test;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * @author jinsheng
 * @date 2021年10月22日 16:11
 */
public class Demo19 {
    private int[][] saveMaxPath = null;
    private int[][] matrix = null;
    int rows;
    int cols;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null) return 0;
        rows = matrix.length;
        cols = matrix[0].length;
        saveMaxPath = new int[rows][cols];
        this.matrix = matrix;
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(dfs(i, j), max);
            }
        }
        return max;
    }

    private int dfs(int row, int col) {
        if (saveMaxPath[row][col] != 0) return saveMaxPath[row][col];
        //上下左右
        int upRow = row - 1;
        int upCol = col;
        int downRow = row + 1;
        int downCol = col;
        int leftRow = row;
        int leftCol = col - 1;
        int rightRow = row;
        int rightCol = col + 1;
        int maxCross = 0;
        if (judgeCross(upRow, upCol) && judgeGt(row, col, upRow, upCol)) {
            maxCross = Math.max(dfs(upRow, upCol) + 1, maxCross);
        }
        if (judgeCross(downRow, downCol) && judgeGt(row, col, downRow, downCol)) {
            maxCross = Math.max(dfs(downRow, downCol) + 1, maxCross);
        }
        if (judgeCross(leftRow, leftCol) && judgeGt(row, col, leftRow, leftCol)) {
            maxCross = Math.max(dfs(leftRow, leftCol) + 1, maxCross);
        }
        if (judgeCross(rightRow, rightCol) && judgeGt(row, col, rightRow, rightCol)) {
            maxCross = Math.max(dfs(rightRow, rightCol) + 1, maxCross);
        }

        saveMaxPath[row][col] = maxCross;

        return maxCross;
    }

    private boolean judgeCross(int row, int col) {
        if (row < 0 || row >= rows) return false;
        if (col < 0 || col >= cols) return false;
        return true;
    }

    private boolean judgeGt(int row, int col, int plusRow, int plusCol) {
        if (matrix[plusRow][plusCol] > matrix[row][col]) return true;
        return false;
    }

    private static int value = 0;

    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        int leftValue = kthSmallest(root.left, k);
        value++;
        if (k == value) {
            return root.val;
        }
        int rightValue = kthSmallest(root.right, k);
        return leftValue == -1 ? rightValue : leftValue;
    }

    public static void main(String[] args) {
//        Demo19 demo19 = new Demo19();
//
////        {3,4,5}, {3,2,6}, {2, 2, 1}
//        int i = demo19.longestIncreasingPath(new int[][]{{9,9,4}, {6,6,8}, {2, 1, 1}});
//
//        System.out.println(i);
//        TreeNode treeNode = TreeHelper.initTree(new Integer[]{3, 1, 4, null, 2});
//        int i = kthSmallest(treeNode, 1);
//        System.out.println(i);
//        System.out.println(treeNode);

        List<Integer> initList = IntStream.range(1, 10).boxed().collect(Collectors.toList());
//        new ArrayList<Integer>().add(new TreeNode(left))

        // JDBC连接的URL, 不同数据库有不同的格式:
        Connection conn = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            String JDBC_URL = "jdbc:mysql://182.42.116.132:3306/bugstack?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
            String JDBC_USER = "root";
            String JDBC_PASSWORD = "cjsdsg";
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            PreparedStatement preparedStatement = conn.prepareStatement("select * from USER");
            ResultSet resultSet = preparedStatement.executeQuery();
            conn.close();
            System.out.println(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
