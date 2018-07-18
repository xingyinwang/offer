package com.wxy.test;

/**
 * Created by Cser_W on 2018/4/10.
 */
class Base1{}
class Base2{}
interface Inter1{}
interface Inter2{}
public class OuterClass {
    private int age ;
    private String name;

    public OuterClass(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void outerMethod() {
        System.out.println("outerMethod``````````");
    }
    public Inner getInner(){
        return new Inner(1.8);
    }

    class Inner extends Base1 implements Inter1,Inter2{
        private double high = 1.7;

        public Inner(double high) {
            this.high = high;
        }

        public double getHigh() {
            return high;
        }
        public OuterClass getOutClass(){
            return OuterClass.this;
        }
        public void innerMethod() {
            System.out.println("InnerMethod```````");
        }
        public void outTest(){
            System.out.println("name\t"+ getName()+"age\t"+getAge());
            System.out.println(name+"\t" + age);
        }
    }
    public static void main(String[] args){
        Inner inner = new OuterClass(12,"12").getInner();
        inner.innerMethod();
    }

}
