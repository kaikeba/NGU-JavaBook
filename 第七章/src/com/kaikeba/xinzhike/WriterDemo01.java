package com.kaikeba.xinzhike;

import java.io.*;

public class WriterDemo01 {
    public static void main(String[] args) throws IOException {
        // 指定要操作的文件
        File file = new File("c:" + File.separator + "an.txt");
        Writer out = null; // 定义字节输出流对象
        out = new FileWriter(file,true); // 追加模式
        String info = "Hello World!!!";// 要打印的信息
        out.write(info);// 输出内容
        out.close(); // 关闭
        System.out.println("写入成功！");
    }
}
