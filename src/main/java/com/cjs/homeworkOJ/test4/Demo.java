package com.cjs.homeworkOJ.test4;

import java.util.HashMap;

/**
 * @author jinsheng
 * @date 2022年03月21日 21:45
 */
public class Demo {
    static class LRUCache {
        HashMap<Integer,Node> map;
        Node head;
        Node tail;
        int capacity;
        int count;
        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.head = new Node();
            this.tail = new Node();
            this.head.next = this.tail;
            this.tail.pre = this.head;
            this.capacity = capacity;
            this.count = 0;
        }

        public int get(int key) {
            if(capacity==0) return -1;
            if(!map.containsKey(key)) return -1;
            Node node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            insertHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            if(capacity==0) return;
            if(map.containsKey(key)){
                Node node = map.get(key);
                node.value = value;
                node.pre.next = node.next;
                node.next.pre = node.pre;
                insertHead(node);
                return;
            }
            Node node = new Node(key,value);
            if(count<capacity){
                insertHead(node);
                count++;
            }else{
                deleteTail();
                insertHead(node);
            }
            map.put(key,node);
        }

        private void insertHead(Node node){
            node.pre = head;
            node.next = head.next;
            node.next.pre = node;
            head.next = node;
        }

        private void deleteTail(){
            map.remove(tail.pre.key);
            tail.pre = tail.pre.pre;
            tail.pre.next = tail;
        }

        class Node{
            Node pre;
            Node next;
            int key;
            int value;
            public Node(){}
            public Node(int key,int value){
                this.key = key;
                this.value = value;
            }
        }
    }
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1,0);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
