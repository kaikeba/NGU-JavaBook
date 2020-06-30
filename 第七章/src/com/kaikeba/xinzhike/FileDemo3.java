package com.kaikeba.xinzhike;

import java.io.*;

public class FileDemo3 {
    public static void main(String[] args) {
        // 1)确定文件资源位置，创建File对象
        File file = new File("c:" + File.separator + "an.txt"); // 指定要操作的文件
        OutputStream out = null; // 定义字节输出流对象
        try {
            // 2）根据File对象创建字节流对象
            out = new FileOutputStream(file, true); // 实例化操作的父类对象,内容追加模式
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String info = "Hello World！\r\n";   // 要写入的信息，\r\n表示换行
        byte b[] = info.getBytes();         // 将字符串变为字节数组
        try {
            // 3）进行读或写操作，此处是写入
            out.write(b);// 写入内容
            System.out.println("写入成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // 4）关闭流
            out.close(); // 关闭
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
