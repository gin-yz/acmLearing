package com.cjs.acmLearing.dataStrcuturesLearn.graphLearn;

import java.util.List;

public interface GraphInterface {
    List<String> getVertexList(); //get结点

    int getNumOfEdge(); //get边数量

    void printGraph(); //打印临界矩阵

    void insertEdge(int v1, int v2, int weight); //设置边

    public int[][] getEdgesMatrix(); //get临接矩阵

}
