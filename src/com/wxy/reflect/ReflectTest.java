package com.wxy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by Cser_W on 2018/5/11.
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
      Class<?> aClass = new MyClassLoader().findClass("E:\\IDEACode\\offer\\Person.class");
        Class<?> abClass = new MyClassLoader().loadClass("E:\\IDEACode\\offer\\Person.class");
        Object instance = aClass.newInstance();
        Constructor<?>[] constructors = aClass.getConstructors();
        Method method = aClass.getMethod("setName", (new String[0]).getClass());


    }
}
