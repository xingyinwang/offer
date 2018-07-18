package com.wxy.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Cser_W on 2018/5/11.
 */
public class MyClassLoader extends ClassLoader {
    private byte[] getBytes(String fileName) throws IOException {
        File file = new File(fileName);
        long length = file.length();
        byte[] raw = new byte[(int)length];
        try (FileInputStream fin = new FileInputStream(file)) {
            int read = fin.read(raw);
            if (read != length) {
                throw new IOException("无法读取全部文件");
            }
            return raw;
        }
    }

    //重写ClassLoader

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        //String classFileName = "";
        File clasFile = new File(name);

        if (clasFile.exists()) {
            try {
                byte[] raw = getBytes(name);
                clazz = defineClass(name,raw,0,raw.length);
                System.out.println("wojiukankna");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (clazz == null) {
            throw new ClassNotFoundException(name);
        }
        return clazz;
    }
}
