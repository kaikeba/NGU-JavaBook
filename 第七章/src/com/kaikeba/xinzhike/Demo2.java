package com.kaikeba.xinzhike;

import java.io.*;

public class Demo2 {
    public static void main(String[] args) throws Exception {
        //1）创建反序列化流
        ObjectInputStream ois =
                new ObjectInputStream(
                        new FileInputStream("c://an.bin"));
        //2）读取对象数据到Student对象，注意强制类型转换
        Student s = (Student) ois.readObject();
        System.out.println(s.getName() + "考试成绩是：" + s.getScore());
        // 3）关闭流
        ois.close();
    }
}
