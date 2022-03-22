package com.cjs.homeworkOJ.test2;

import java.util.concurrent.TimeUnit;

/**
 * @author jinsheng
 * @date 2021年12月23日 14:32
 */
public class Demo6 {

    public static void main(String[] args) {

        Object LOCK1 = new Object();
        Object LOCK2 = new Object();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (LOCK1){
                        System.out.println(Thread.currentThread().getName()+",获得LOCK1，申请LOCK2");
                        TimeUnit.SECONDS.sleep(1);
                        synchronized (LOCK2){
                            System.out.println(Thread.currentThread().getName()+",获得LOCK2，释放LOCK2");
                        }
                        System.out.println(Thread.currentThread().getName()+"释放LOCK1");

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (LOCK2){
                        System.out.println(Thread.currentThread().getName()+",获得LOCK2，申请LOCK1");
                        TimeUnit.SECONDS.sleep(1);
                        synchronized (LOCK1){
                            System.out.println(Thread.currentThread().getName()+",获得LOCK1，释放LOCK1");
                        }
                        System.out.println(Thread.currentThread().getName()+"释放LOCK12");

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
