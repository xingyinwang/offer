package com.wxy.test;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Cser_W on 2018/4/2.
 */
public class testI {
    @Test
    public void byteToChar(){
        byte b = 120;
        char ch = (char) b;
        assert ch == 'x';
        System.out.println(ch);
    }
    @Test
    public void charToByte() {
        char ch = 'x';
        byte by = Byte.parseByte((int)ch + "");
        System.out.println(by);
    }
    @Test
    public void test1() {
        int i = 1;
        int j = i++;
        System.out.println("i="+i+"  j="+j);
        Math.sqrt(1.0);
    }

    @Test
    public void test2() {
        int i = 1;
        int j = ++i;
        System.out.println("i="+i+"  j="+j);
    }
    @Test
    public void test3(){
        int count = 0;
        for (int i = 0; i < 100; i++) {
            count = count++;
        }
        System.out.println(count);
    }
    //不允许在方法中设置静态变量
 /*   public int f(){
        static int i = 0;

    }*/

    //泛型遇见重载
   /* public void method(ArrayList<String> list){}
    public void method(ArrayList<Integer> list){}*/


   // == 在遇到运算符的情况下会自动拆箱
    // equals方法不处理数据转型的关系
    @Test
    public void testCandy(){
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d); //true
        System.out.println(e == f); // flase
        System.out.println(c == (a + b)); //true
        System.out.println(c.equals(a+b)); // true
        System.out.println(g == (a + b)); //true
        System.out.println(g.equals(a + b)); //false
    }
}
