/**
 * ｐｒｉｍ是求最小生成树的算法
 */

package com.cjs.acmLearing.primLearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimSelfDemo {


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

        selfAdvancePrim(graph, 0);

    }

    public static void prim(Graph graph, int v) {
        boolean[] isVisited = new boolean[graph.getVerxs()]; //是否已经遍历过

        isVisited[v] = true;

        int minWeight = 10000;

        int sum = 0;

        int[][] tempWeight = graph.getWeight();

        //存放临时下标
        int tempj = 0;
        int tempk = 0;

        //只需要找顶点数减１的边
        for (int i = 0; i < graph.getVerxs() - 1; i++) {

            for (int j = 0; j < graph.getVerxs(); j++) {
                for (int k = 0; k < graph.getVerxs(); k++) {
                    if (isVisited[j] && !isVisited[k] && (tempWeight[j][k] < minWeight)) {
                        minWeight = tempWeight[j][k];
                        tempj = j;
                        tempk = k;

                    }
                }
            }
            sum += minWeight;
            isVisited[tempk] = true;
            System.out.println(graph.getData()[tempj] + "-" + graph.getData()[tempk] + "   " + minWeight);

            minWeight = 10000;
        }

        System.out.println("sum=" + sum);
    }

    public static void selfAdvancePrim(Graph graph, int v) {

        int minWeight = 10000;

        int sum = 0;

        int[][] tempWeight = graph.getWeight();

        //存放临时下标
        int tempj = 0;
        int tempk = 0;

        //存放已经选择的顶点
        List<Integer> list = new ArrayList<>();
        list.add(v);

        for (int i = 0; i < graph.getVerxs() - 1; i++) {
            for (Integer j : list) {
                for (int k = 0; k < graph.getVerxs(); k++) {
                    if (!list.contains(k) && tempWeight[j][k] < minWeight) {
                        minWeight = tempWeight[j][k];
                        tempj = j;
                        tempk = k;

                    }
                }
            }
            sum += minWeight;
            list.add(tempk);
            System.out.println(graph.getData()[tempj] + "-" + graph.getData()[tempk] + "   " + minWeight);

            minWeight = 10000;
        }

        System.out.println("sum=" + sum);
    }
}

class Graph {
    /**
     * @param verxs 顶点的个数
     * @param data　顶点对应的名称
     * @param weight　各个边对应的权重
     */
    private final int verxs;
    private final char[] data;
    private final int[][] weight;


    public Graph(int verxs, char[] data, int[][] weight) {
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

