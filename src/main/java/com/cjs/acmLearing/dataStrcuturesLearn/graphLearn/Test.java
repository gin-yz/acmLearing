package com.cjs.acmLearing.dataStrcuturesLearn.graphLearn;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        GraphInterface graph = new GraphModel(8, List.of("1", "2", "3", "4", "5", "6", "7", "8"));
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        System.out.println();

        graph.printGraph();

        new DFSModel(graph);

        System.out.println();
        new BFSModel(graph);
    }
}
