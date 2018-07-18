package com.wxy.test;

import java.io.*;

/**
 * Created by Cser_W on 2018/4/20.
 */
public class IOTest implements Serializable{
    private static final long serialVersionUID = -2112523452352355443L;
    int number = 9;
    public static void main(String[] args){
        try {
            FileOutputStream fos = new FileOutputStream("E:\\IDEACode\\offer\\src\\com\\wxy\\test\\serialize.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            IOTest serialize = new IOTest();
            oos.writeObject(serialize);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fin = new FileInputStream("E:\\IDEACode\\offer\\src\\com\\wxy\\test\\serialize.dat");
            ObjectInputStream ois = new ObjectInputStream(fin);
            IOTest o = (IOTest)ois.readObject();
            System.out.println(o.number);
            ois.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
