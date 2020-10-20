package com.cjs.acmLearing.floydLearn;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FloydSelfDemo {
    private static final int INF = Integer.MAX_VALUE;
    private final int[][] pre;
    private final int[][] maxtrix;
    private final char[] vertex;
    private final Map<Character, Map<Character,List<Character>>> finalResult;

    public FloydSelfDemo(int[][] maxtrix, char[] vertex) {
        this.maxtrix = maxtrix;
        this.vertex = vertex;
        this.pre = new int[vertex.length][vertex.length];
        for (int i = 0; i < vertex.length; i++) {
            Arrays.fill(pre[i], -1);
        }
        this.finalResult = new HashMap<>();
        floyd();

    }

    private void getPath(int start, int end, List<Character> list) {
        int k = pre[start][end];
        if (k == -1) return;
        getPath(start, k, list);
        list.add(this.vertex[k]);
        getPath(k, end, list);
    }

    private void floyd() {
        for (int k = 0; k < vertex.length; k++) { //经过的边
            for (int i = 0; i < vertex.length; i++) { //起点
                for (int j = 0; j < vertex.length; j++) { //终点
                    if (k == i || k == j || i == j) continue;
                    if (maxtrix[i][k] != INF && maxtrix[k][j] != INF && maxtrix[i][k] + maxtrix[k][j] < maxtrix[i][j]) {
                        maxtrix[i][j] = maxtrix[i][k] + maxtrix[k][j];
                        pre[i][j] = k;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {INF, 30, INF, 10, 50},
                {INF, INF, 60, INF, INF},
                {INF, INF, INF, INF, INF},
                {INF, INF, INF, INF, 30},
                {50, INF, 40, INF, INF},
        };

        char[] vertex = {'A', 'B', 'C', 'D', 'E'};

        FloydSelfDemo floydSelfDemo = new FloydSelfDemo(matrix,vertex);

//        Arrays.stream(floydSelfDemo.pre).forEach(new Consumer<int[]>() {
//            @Override
//            public void accept(int[] ints) {
//                System.out.println(Arrays.toString(ints));
//            }
//        });

        List<Character> list = new ArrayList<>();
        int start = 0;
        int end = 2;
        floydSelfDemo.getPath(start,end,list);
        list.add(0,vertex[start]);
        list.add(vertex[end]);
        System.out.println(list);
        System.out.println(floydSelfDemo.maxtrix[start][end]);

    }
}
