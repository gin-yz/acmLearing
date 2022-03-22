package com.cjs.homeworkOJ.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jinsheng
 * @date 2021年10月12日 14:34
 */
public class demo11 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> noNullList = new ArrayList<>();
        if(lists == null || lists.length ==0) return null;
        for(int i =0;i<lists.length;i++){
            if(lists[i]!=null){
                noNullList.add(i);
            }
        }
        ListNode h = new ListNode(-1);
        ListNode p = h;

        while(!noNullList.isEmpty()){
            int minNodeValue = Integer.MAX_VALUE;
            int minNodeIndex = 0;
            for(int i =0;i<noNullList.size();i++){
                if(lists[noNullList.get(i)]!=null){
                    if(minNodeValue>lists[noNullList.get(i)].val){
                        minNodeIndex = i;
                        minNodeValue = lists[noNullList.get(i)].val;
                    }
                }
            }
            if(noNullList.isEmpty()) break;
            p.next = lists[noNullList.get(minNodeIndex)];
            lists[noNullList.get(minNodeIndex)] = lists[noNullList.get(minNodeIndex)].next;
            if(lists[noNullList.get(minNodeIndex)] ==null){
                noNullList.remove(minNodeIndex);
            }
            p = p.next;
        }

        return h.next;
    }

    public static void main(String[] args) {

//        [[1,4,5],[1,3,4],[2,6]]
        ListNode[] array=new ListNode[3];
        array[0] =  new ListNode(1, new ListNode(4, new ListNode(5)));
        array[1] =  new ListNode(1, new ListNode(3, new ListNode(4)));
        array[2] =  new ListNode(2, new ListNode(6));
//        array[1] =  new ListNode(1);

        ListNode listNode = mergeKLists(array);

        System.out.println(listNode);
    }
}
