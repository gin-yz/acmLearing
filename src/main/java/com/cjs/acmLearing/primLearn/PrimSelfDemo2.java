/**
 * ｐｒｉｍ是求最小生成树的算法
 */

package com.cjs.acmLearing.primLearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimSelfDemo2 {


    public static void main(String[] args) {

        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};

        Graph graph = new Graph(data.length, data, weight);

        graph.printGraph();

        prim(graph, 0);

    }

    public static void prim(Graph graph, int v) {
        List<Integer> hasVisitedList = new ArrayList<>();

        int minNum = 10000;
        int tempi = 0;
        int tempj = 0;
        int sum = 0;

        hasVisitedList.add(v);

        char[] tempData = graph.getData();
        int[][] tempWeight = graph.getWeight();

        for (int k = 0; k < graph.getVerxs() - 1; k++) {
            for (int i : hasVisitedList) {
                for (int j = 0; j < graph.getVerxs(); j++) {
                    if (!hasVisitedList.contains(j) && tempWeight[i][j] < minNum) {
                        minNum = tempWeight[i][j];
                        tempi = i;
                        tempj = j;
                    }
                }
            }
            System.out.println(tempData[tempi]+"==>>"+tempData[tempj]+" and weight:"+minNum);
            hasVisitedList.add(tempj);
            sum +=minNum;
            minNum = 10000;
        }

        System.out.println("min sum is:"+sum);

    }


}

class Graph2 {
    /**
     * @param verxs 顶点的个数
     * @param data　顶点对应的名称
     * @param weight　各个边对应的权重
     */
    private final int verxs;
    private final char[] data;
    private final int[][] weight;


    public Graph2(int verxs, char[] data, int[][] weight) {
        this.verxs = verxs;
        this.data = data;
        this.weight = weight;
    }

    public int getVerxs() {
        return verxs;
    }

    public char[] getData() {
        return data.clone();
    }

    public int[][] getWeight() {
        int[][] tempWeight = new int[verxs][verxs];
        for (int i = 0; i < tempWeight.length; i++) {
            tempWeight[i] = weight[i].clone();
        }
        return tempWeight;
    }

    public void printGraph() {
        for (int[] ints : weight) {
            System.out.println(Arrays.toString(ints));
        }
    }
}

