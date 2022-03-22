//判断一个链表是不是回文链表
package com.cjs.advanceLearn.recusiveList;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.cjs.advanceLearn.recusiveList.LimitRange.Node;

import javax.management.NotificationEmitter;

public class ListHuiWenSuJudge {
    public static void main(String[] args) {
        List<LimitRange.Node> nodeList = List.of(1,2,2,1).stream().map(Node::new).collect(Collectors.toList());
        for (int i = 0; i < nodeList.size() - 1; i++) {
            nodeList.get(i).next = nodeList.get(i + 1);
        }
        LimitRange.Node head = nodeList.get(0);
        Boolean newList = judgeHuiWen(head);
        System.out.println(newList);

    }

    public static Node firstNode ;
    public static Boolean judgeHuiWen(Node head){
        firstNode = head;
        return judgeHuiWenSub(head);
    }

    public static Boolean judgeHuiWenSub(Node currNode){
        if (currNode.next == null){
            Boolean judge = currNode.value == firstNode.value;
            firstNode = firstNode.next;
            return judge;
        }

        Boolean nextJudge = judgeHuiWenSub(currNode.next);

        if (nextJudge) {
            Boolean judge = currNode.value == firstNode.value;
            firstNode = firstNode.next;
            return judge;
        }else return false;
    }


}
