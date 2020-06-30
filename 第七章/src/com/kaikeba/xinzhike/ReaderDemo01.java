package com.kaikeba.xinzhike;

import java.io.*;

public class ReaderDemo01 {
    public static void main(String[] args) throws IOException {
        File file = new File("c:" + File.separator + "an.txt");// 要读取的文件路径
        Reader input = null; // 字节输入流
        input = new FileReader(file);
        char b[] = new char[(int)file.length()];// 开辟char数组空间，读取内容
        int len = input.read(b); // 读取
        input.close();// 关闭
        System.out.println(new String(b, 0, len));
    }
}
