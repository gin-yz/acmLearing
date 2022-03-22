package com.cjs.advanceLearn.recusiveList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LimitRange {
    public static void main(String[] args) {
        List<Node> nodeList = IntStream.range(1, 6).mapToObj(Node::new).collect(Collectors.toList());
        for (int i = 0; i < nodeList.size() - 1; i++) {
            nodeList.get(i).next = nodeList.get(i + 1);
        }
        Node head = nodeList.get(0);
        Node newList = complexReacuse(head, 1,4);
        while (newList != null) {
            System.out.println(newList.value);
            newList = newList.next;
        }

    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //从头节点开始反转到第ｎ个结点
    public static Node continusNode = null;

    public static Node recuisveList(Node node, int end) {
        if (end == 1) {
            continusNode = node.next;
            return node;
        }
        Node newList = recuisveList(node.next, end - 1);
        node.next.next = node;
        node.next = continusNode;
        return newList;
    }

    //最简单的反转
    public static Node simpleRecuise(Node head) {
        if (head.next == null) return head;
        Node newList = simpleRecuise(head.next);
        head.next.next = head;
        head.next = null;
        return newList;
    }

    //指定开始和结尾反转
    public static Node complexReacuse(Node head, int start, int end) {
        Node startHead = head;
        while (start>1){
            head = head.next;
            start--;
        }
        Node reveriseHead = head;

        reveriseHead.next = recuisveList(reveriseHead.next, end - start);
        return startHead;
    }
}
