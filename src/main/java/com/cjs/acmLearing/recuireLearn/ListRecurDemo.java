//反转列表1->2->3->4为4->3->2->1

package com.cjs.acmLearing.recuireLearn;

import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListRecurDemo {
    public static void main(String[] args) {
        List<Node> nodeList = IntStream.range(0, 4).mapToObj(new IntFunction<Node>() {
            @Override
            public Node apply(int value) {
                return new Node(value);
            }
        }).collect(Collectors.toList());

        nodeList.get(0).next = nodeList.get(1);
        nodeList.get(1).next = nodeList.get(2);
        nodeList.get(2).next = nodeList.get(3);

        Node head = nodeList.get(0);

//        Node node = reverseList(head);
        Node node = noReReverseList(head);
        while (node!=null){
            System.out.println(node.value);
            node = node.next;
        }


    }

    private static class Node{
        public Node(int value) {
            this.value = value;
        }

        public int value;
        public Node next;
    }

    //递归实现
    private static Node reverseList(Node head){
        if (head.next ==null) return head;

        Node newList = reverseList(head.next);

        Node nextNode = head.next;

        nextNode.next = head;

        head.next = null;

        return newList;
    }

    //非递归
    private static Node noReReverseList(Node head){

        Node newHead = new Node(0);

        newHead.next = null;

        Node oldHead = new Node(0);

        oldHead.next = head;

        while (oldHead.next!=null){
            Node node= oldHead.next;

            oldHead.next = oldHead.next.next;

            node.next = newHead.next;

            newHead.next = node;
        }

        return newHead.next;
    }
}
