package com.cjs.acmLearing.dataStrcuturesLearn.graphLearn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GraphModel implements GraphInterface{
    private List<String> vertexList; //图的节点
    private int[][] edges;//存储图对应的邻结矩阵
    private int numOfEdge; //图的边的个数

    public GraphModel(int n, List<String> vertexList) {
        if (vertexList.size() != n) {
            throw new IllegalArgumentException("n!=vertexlist.size");
        }
        this.vertexList = vertexList;
        this.edges = new int[n][n];
    }

    public List<String> getVertexList() {
        return Collections.unmodifiableList(this.vertexList);
    }

    public int[][] getEdgesMatrix() {
        int[][] temp = new int[this.edges.length][this.edges[0].length];
        for (int i = 0; i < edges.length; i++) {
            temp[i] = this.edges[i].clone();
        }
        return temp;
    }

    public int getNumOfEdge() {
        return numOfEdge;
    }

    public void printGraph() {

        Arrays.stream(this.edges).map(new Function<int[], List<Integer>>() {
            @Override
            public List<Integer> apply(int[] ints) {
                return Arrays.stream(ints).boxed().collect(Collectors.toList());
            }
        }).forEach(System.out::println);
    }

    public void insertEdge(int v1, int v2, int weight) {
        this.edges[v1][v2] = weight;
        this.edges[v2][v1] = weight;
        this.numOfEdge++;
    }

}
