package com.cjs.homeworkOJ.test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jinsheng
 * @date 2021年12月29日 21:53
 */
public class Demo22 {
    public static int[] LRU(int[][] operators, int k) {
        HashMap<Integer, Node> hashMap = new HashMap<>();
        LinkedList<Integer> resList = new LinkedList<>();
        Node head = new Node(-1, -1, null, null);
        Node tail = new Node(-1, -1, head, null);
        head.next = tail;
        int count = 0;
        //后进，前出
        for (int[] op : operators) {
            if (op[0] == 1) {
                if (count < k) {
                    Node node = new Node(op[1], op[2], tail.pre, tail);
                    tail.pre.next = node;
                    tail.pre = node;
                    hashMap.put(op[1], node);
                    count++;
                } else {
                    Node removeNode = head.next;
                    hashMap.remove(removeNode.key);
                    head.next = removeNode.next;
                    removeNode.next.pre = head;
                    removeNode.next = null;
                    removeNode.pre = null;
                    Node node = new Node(op[1], op[2], tail.pre, tail);
                    tail.pre.next = node;
                    tail.pre = node;
                    hashMap.put(op[1], node);
                }
            } else {
                Node node = hashMap.get(op[1]);
                if (node == null) resList.addLast(-1);
                else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                    node.pre = tail.pre;
                    node.next = tail;
                    tail.pre.next = node;
                    tail.pre = node;
                    resList.addLast(node.value);
                }
            }
        }
        int[] resArray = new int[resList.size()];
        for (int i = 0; i < resArray.length; i++) {
            resArray[i] = resList.poll();
        }
        return resArray;
    }

    static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value, Node pre, Node next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        LRU(new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}}, 3);

        ReentrantLock lock = new ReentrantLock();

        Condition condition = lock.newCondition();

        Condition condition1 = lock.newCondition();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();

                System.out.println(Thread.currentThread().getName());
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
                System.out.println(Thread.currentThread().getName());
            }
        });

        thread.start();
        thread1.start();

        TimeUnit.SECONDS.sleep(2);

        System.out.println(condition==condition1);

        ThreadLocal<String> he = new ThreadLocal<>();

        String s = he.get();

    }
}
