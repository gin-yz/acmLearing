/*
 * 先查找第一个结点，再遍历的找出后面的结点．
 *
 * */


package com.cjs.acmLearing.dataStrcuturesLearn.graphLearn;

import java.util.ArrayList;
import java.util.List;

public class DFSModel {
    private final GraphInterface graphModel;
    private boolean isVisited[];

    public DFSModel(GraphInterface graphModel) {
        this.graphModel = graphModel;
        isVisited = new boolean[graphModel.getVertexList().size()];
        init();
    }


    private void init() {
        for (int i = 0; i < graphModel.getVertexList().size(); i++) {
            if (!isVisited[i]) {
                dfs(i);
            }
        }
    }

    private void dfs(int v1) {
        isVisited[v1] = true;
        System.out.println(this.graphModel.getVertexList().get(v1));

        int w = getFirstVertex(v1);
        while (w != -1) {
            if(!isVisited[w]) dfs(w);

            w = getNextVertex(v1, w);
        }
    }

    private int getFirstVertex(int v1) {
        for (int i = 0; i < graphModel.getVertexList().size(); i++) {
            if (graphModel.getEdgesMatrix()[v1][i] != 0) {
                return i;
            }
        }
        return -1;
    }

    private int getNextVertex(int v1, int v2) {
        for (int i = v2 + 1; i < graphModel.getVertexList().size(); i++) {
            if (graphModel.getEdgesMatrix()[v1][i] != 0 && !isVisited[i]) {
                return i;
            }
        }
        return -1;
    }


}
