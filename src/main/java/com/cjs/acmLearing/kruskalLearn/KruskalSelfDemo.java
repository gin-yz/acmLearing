package com.cjs.acmLearing.kruskalLearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class KruskalSelfDemo {
    private int edgeNum; //边的个数
    private char[] vertexs; //顶点数组
    private int[][] matrix; //邻接矩阵
    //使用 INF 表示两个顶点不能连通
    private static final int INF = Integer.MAX_VALUE;
    //边的有序列表
    private List<EData> edgeList;
    //存储各节点的顶点
    private int[] end;

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

        KruskalSelfDemo kruskalSelfDemo = new KruskalSelfDemo(vertexs, matrix);
        kruskalSelfDemo.kruskal();
    }

    public KruskalSelfDemo(char[] vertexs, int[][] matrix) {
        //初始化顶点数和边的个数
        int vlen = vertexs.length;

        //初始化顶点, 复制拷贝的方式
        this.vertexs = vertexs.clone();

        //初始化边, 使用的是复制拷贝的方式
        this.matrix = new int[vlen][];
        for (int i = 0; i < vlen; i++) {
            this.matrix[i] = matrix[i].clone();
        }
        //统计边的条数
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }

        //生成边有序列表
        this.edgeList = new ArrayList<>();
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (this.matrix[i][j] != INF) {
                    this.edgeList.add(new EData(i, j, this.matrix[i][j]));
                }
            }
        }
        this.edgeList.sort(new Comparator<EData>() {
            @Override
            public int compare(EData o1, EData o2) {
                return o1.weight >= o2.weight ? o1.weight == o2.weight ? 0 : 1 : -1;
            }
        });

        //初始化ｅｎｄ数组,存储顶点
        end = new int[vertexs.length];
        Arrays.fill(end, -1);
    }

    public void kruskal() {
        List<EData> visitedEdgeList = new ArrayList<>();

        for (EData eData : edgeList) {
            int first = getEnd(eData.start);
            int end = getEnd(eData.end);

            if (first != end) {
                this.end[end] = first;
                visitedEdgeList.add(eData);
            }

        }
        visitedEdgeList.stream().map(obj -> vertexs[obj.start] + "" + vertexs[obj.end] + " weight:" + obj.weight).forEach(System.out::println);
    }

    //查找节点的顶点，
    private int getEnd(int v) {
        while (end[v] != -1) {
            v = end[v];
        }
        return v;
    }

}

//创建一个类EData ，它的对象实例就表示一条边
class EData {
    public int start; //边的一个点
    public int end; //边的另外一个点
    public int weight; //边的权值

    //构造器
    public EData(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }


}
