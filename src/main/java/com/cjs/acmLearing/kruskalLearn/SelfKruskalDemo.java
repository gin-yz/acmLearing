package com.cjs.acmLearing.kruskalLearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SelfKruskalDemo {
    private char[] vertexs;
    private static final int INF = Integer.MAX_VALUE;
    private int[][] matrix;
    private final int[] ends;
    private int edgeNum;
    private List<EdgeValue> edgeValueList;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}};
        //大家可以在去测试其它的邻接矩阵，结果都可以得到最小生成树.

        SelfKruskalDemo kruskalSelfDemo = new SelfKruskalDemo(vertexs, matrix);

    }

    public SelfKruskalDemo(char[] vertexs, int[][] matrix) {
        this.matrix = matrix;
        this.vertexs = vertexs;
        this.ends = new int[vertexs.length];
        Arrays.fill(ends, -1);
        this.edgeValueList = new ArrayList<>();

        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edgeNum++;
                    this.edgeValueList.add(new EdgeValue(i, j, matrix[i][j]));
                }
            }
        }

        this.edgeValueList.sort(new Comparator<EdgeValue>() {
            @Override
            public int compare(EdgeValue o1, EdgeValue o2) {
                return o1.getWeight() >= o2.getWeight() ? o1.getWeight() == o2.getWeight() ? 0 : 1 : -1;
            }
        });

        kruskal();

    }

    private void kruskal() {
        List<EdgeValue> finalEdageList = new ArrayList<>();

        for (EdgeValue edge : this.edgeValueList) {
            int start = getEnd(edge.getStart());
            int end = getEnd(edge.getEnd());

            if (start != end) {
                finalEdageList.add(edge);
                this.ends[end] = start;
            }
        }

        finalEdageList.stream().map(obj -> ""+this.vertexs[obj.getStart()] + this.vertexs[obj.getEnd()] + ":" + obj.getWeight()).forEach(System.out::println);
    }

    private int getEnd(int v) {
        while (ends[v] != -1) {
            v = ends[v];
        }
        return v;
    }

}


class EdgeValue {
    private final int start;
    private final int end;
    private final int weight;

    public EdgeValue(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "EdgeValue{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}