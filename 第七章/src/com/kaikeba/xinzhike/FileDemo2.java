package com.kaikeba.xinzhike;

import java.io.File;

public class FileDemo2 {
    public static void main(String[] args) {
        File file = new File("c:" + File.separator + "Test"); // 目录路径
        String str[] = file.list(); // 列出目录中内容
        System.out.println("---list()列出c:\\Test下所有目录级文件名称---");
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
        System.out.println("---listFiles()列出c:\\Test下所有目录级文件完整路径---");
        File files[] = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }
}