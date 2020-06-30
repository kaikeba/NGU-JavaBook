package com.kaikeba.xinzhike;

import java.io.*;

public class FileDemo4 {
    public static void main(String[] args) {
        // 1)确定文件资源位置，创建File对象
        File file = new File("c:" + File.separator + "an.txt");
        InputStream input = null; // 字节输入流
        try {
            // 2）根据File对象创建字节流对象
            input = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte b[] = new byte[(int) file.length()];// 根据文件大小，开辟byte数组空间
        try {
            // 3）进行读或写操作，此处是读取
            input.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // 4）关闭流
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 控制台输出读取内容
        System.out.println(new String(b));
    }
}