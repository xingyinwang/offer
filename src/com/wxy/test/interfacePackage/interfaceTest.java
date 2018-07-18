package com.wxy.test.interfacePackage;

/**
 * Created by Cser_W on 2018/5/27.
 */

public class interfaceTest implements IA, IB{

    @Override
    public void play() {
        System.out.println("who is ?");
    }
    public static void main(String[] args){
        int[] array = new int[]{1,2,3};
        int[] clone = array.clone();
        clone[2] = 5;
        assert (2 == 1);
        new interfaceTest().play();
    }
    class aa implements Cloneable{
        @Override
        public aa clone() throws CloneNotSupportedException {
            return (aa) super.clone();
        }
    }
}
