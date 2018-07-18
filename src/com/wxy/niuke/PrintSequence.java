package com.wxy.niuke;

/**
 * Created by Kode on 2018/7/12.
 * 使用两个线程连续打印123456....
 */
public class PrintSequence {
    public static  int count = 1;
    private static Object object = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (count <= 20) {
                    synchronized (object) {
                        if (count % 2 != 0)
                            System.out.println(count++ + " : " + Thread.currentThread().getName());
                        else {
                            object.notifyAll();
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (count <= 20) {
                    synchronized (object) {
                        if (count % 2 == 0) {
                            System.out.println(count++ + " : " + Thread.currentThread().getName());
                        } else {
                            object.notifyAll();
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}