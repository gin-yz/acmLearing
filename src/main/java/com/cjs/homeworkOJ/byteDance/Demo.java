package com.cjs.homeworkOJ.byteDance;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Scanner;

/**
 * 523 266 415
 *
 * @author jinsheng
 * @date 2022年03月21日 16:34
 */

public class Demo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Condition condition1 = lock.newCondition();
        int[] array = new int[]{1};
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        if (array[0] == 1) {
                            array[0] = 2;
                            System.out.println("a");
                            condition1.signal();
                            condition.wait();
                        } else {
                            condition.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.unlock();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        if (array[0] == 2) {
                            array[1] = 1;
                            System.out.println("b");
                            condition.signal();
                            condition1.wait();
                        } else {
                            condition1.await();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.unlock();
                }
            }
        });

        thread.start();
        thread2.start();

        System.out.println(Double.MIN_VALUE);
    }
}

