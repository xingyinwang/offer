package com.wxy.javaThread.RunnbaleDemo;

/**
 * Created by Cser_W on 2018/4/23.
 */
class MyThread implements Runnable {
    private int ticketCount = 5;

    @Override
    public void run() {
        while (ticketCount > 0) {
            ticketCount--;
            System.out.println(Thread.currentThread().getName() + " 卖出了一张票，还剩下的票数为： " + ticketCount);
        }
    }
}

public class RunnableTicket {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread mt1 = new Thread(mt, "窗口1");
        Thread mt2 = new Thread(mt, "窗口2");
        Thread mt3 = new Thread(mt, "窗口3");
        mt1.start();
        mt2.start();
        mt3.start();
    }
}
