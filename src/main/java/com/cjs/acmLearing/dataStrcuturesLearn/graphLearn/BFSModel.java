package com.cjs.acmLearing.dataStrcuturesLearn.graphLearn;

import java.util.LinkedList;

public class BFSModel {
    private final GraphInterface graphModel;
    private boolean isVisited[];


    public BFSModel(GraphInterface graphModel) {
        this.graphModel = graphModel;
        isVisited = new boolean[graphModel.getVertexList().size()];
        init();
    }


    private void init() {
        for (int i = 0; i < graphModel.getVertexList().size(); i++) {
            if (!isVisited[i]) {
                bfs(i);
            }
        }
    }

    private void bfs(int v1) {
        LinkedList<Integer> queue = new LinkedList<>();

        queue.addFirst(v1);
        System.out.println(v1);
        isVisited[v1] = true;

        while (!queue.isEmpty()) {
            int u = queue.removeLast();

            int w = getFirstVertex(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    isVisited[w] = true;
                    queue.addFirst(w);
                    System.out.println(w);
                }
                w = getNextVertex(u, w);

            }
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
