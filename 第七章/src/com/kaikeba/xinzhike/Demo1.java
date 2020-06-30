package com.kaikeba.xinzhike;

import java.io.*;
// 序列化对象数据
public class Demo1 {
    public static void main(String[] args) throws IOException {
        // 1）准备对象数据
        Student s1 = new Student("武松", 98);
        //2）创建序列化流
        ObjectOutputStream oos =
                new ObjectOutputStream(
                        new FileOutputStream("c://an.bin"));
        // 3）将Student对象s1写入到文件
        oos.writeObject(s1);
        // 4）关闭流
        oos.close();
        System.out.println("程序执行完毕");
    }
}
