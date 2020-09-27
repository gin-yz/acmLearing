/*
 * 使用到了ＢＦＳ的思想
 * 计算一个点到其他点的最短路经
 * */

package com.cjs.acmLearing.dijkstraLearn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class DijKstraSelfDemo {

    private static final int N = Integer.MAX_VALUE;

    private final boolean[] isVisited; //是否访问过
    private final int[] preVertex; //前趋结点
    private final Dgraph graph; //存储图
    private final LinkedList<Integer> tempList; //ＢＦＳ临时队列
    private final int[] distance; //最终距离
    private int startVertex;

    public DijKstraSelfDemo(Dgraph dgraph) {
        this.graph = dgraph;
        this.isVisited = new boolean[graph.getVertexNum()];
        this.preVertex = new int[graph.getVertexNum()];
        this.tempList = new LinkedList<>();
        this.distance = new int[graph.getVertexNum()];
        Arrays.fill(distance, N);
        Arrays.fill(preVertex, -1);
    }


    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};

        Dgraph dgraph = new Dgraph(vertex, matrix);

        DijKstraSelfDemo dijKstraSelfDemo = new DijKstraSelfDemo(dgraph);
        dijKstraSelfDemo.dijkstra(6);
        System.out.println(Arrays.toString(dijKstraSelfDemo.distance));
        System.out.println(Arrays.toString(dijKstraSelfDemo.preVertex));


    }

    private void dijkstra(int v) {
        startVertex = v;
        distance[v] = 0;
        tempList.addLast(v);
        while (!tempList.isEmpty()) {
            int vv = tempList.removeFirst();
            for (int i = 0; i < graph.getVertexNum(); i++) {
                if (i == vv) continue;

                int tempDistance;
                if ((tempDistance = getDistance(vv, i)) < distance[i]) {
                    distance[i] = tempDistance;
                    if (!isVisited[i]) tempList.add(i);
                    isVisited[i] = true;
                    preVertex[i] = vv;
                }
            }

        }

        IntStream.range(0, graph.getVertexNum()).forEach(this::getRoute);

    }

    /**
     * @param v  开始的点
     * @param vv 　目前的点
     * @param i  判断目前的点到其他的点
     * @return
     */
    private int getDistance(int vv, int i) {
        int sum = 0;

        if (graph.getMatrix()[vv][i] != N) {
            sum += graph.getMatrix()[vv][i];
//            if (vv != startVertex) sum += distance[vv];
            sum += distance[vv];
        } else return N;

        return sum;

    }

    private void getRoute(int v) {
        LinkedList<Integer> templist = new LinkedList<>();
        StringBuffer stringBuffer = new StringBuffer();
        while (v != startVertex) {
            templist.addFirst(v);
            v = this.preVertex[v];
        }
        for (int i : templist) {
            stringBuffer.append("=>>");
            stringBuffer.append(this.graph.getVertex()[i]);
        }

        System.out.println(stringBuffer);
    }


}

class Dgraph {
    private final char[] vertex;
    private final int[][] matrix;
    private final int vertexNum;

    public Dgraph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
        this.vertexNum = vertex.length;
    }

    public char[] getVertex() {
        return vertex.clone();
    }

    public int[][] getMatrix() {
//        int[][] tempMatrix = new int[vertex.length][];
//        for (int i =0;i<tempMatrix.length;i++){
//            tempMatrix[i] = matrix[i].clone();
//        }
        return matrix;
    }

    public int getVertexNum() {
        return vertexNum;
    }
}