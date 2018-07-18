package com.wxy.javaThread.ThreadDemo;

/**
 * Created by Cser_W on 2018/4/23.
 */
class MyThread extends Thread {
    private  int ticketCount = 5;
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (ticketCount > 0) {
            ticketCount--;
            System.out.println(name + "卖出了一张票，还剩下的票数为：" + ticketCount);
        }
    }
}
public class ThreadTicket {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("窗口1");
        MyThread mt2 = new MyThread("窗口2");
        MyThread mt3 = new MyThread("窗口3");
        mt1.start();
        mt2.start();
        mt3.start();
    }
}
