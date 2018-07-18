package com.wxy.javaThread.DaemoThread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Created by Cser_W on 2018/4/23.
 */
class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println("进入到后台线程！");
        try {
            writeToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("退出了后台线程");
    }
    private void writeToFile() throws Exception {
        File fileName = new File("d:"+File.separator+"dameo.txt");
        OutputStream os = new FileOutputStream(fileName, true);
        int count = 0;
        while (count < 999) {
            os.write(("\r\nword"+count).getBytes());
            System.out.println("守护线程"+ Thread.currentThread().getName() +
            "向文件中写入了Word "+count);
            Thread.sleep(1000);
            count++;
        }
    }
}
public class DameoThread {
    public static void main(String[] args){
        MyThread mt = new MyThread();
        Thread mt1 = new Thread(mt, "守护线程");
        mt1.setDaemon(true);
        mt1.start();
        System.out.println("进入到主线程"+ Thread.currentThread().getName());
        Scanner sc = new Scanner(System.in);
        sc.next();
        System.out.println("退出主线程"+ Thread.currentThread().getName());
    }
}

