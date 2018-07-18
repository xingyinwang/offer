package com.wxy.test;

/**
 * Created by Cser_W on 2018/4/16.
 */
public class 死锁模拟 {
    static String A = "A";
    static String B = "B";

    public static void main(String[] args) {
        new 死锁模拟().deadDemo();
    }

    public  void deadDemo() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        System.out.println(" 锁住A");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                synchronized (B) {
                    try {
                        System.out.println("要锁住B");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        try {
                            System.out.println("要锁住A");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });
        t1.start();
        t2 .start();
    }
}
