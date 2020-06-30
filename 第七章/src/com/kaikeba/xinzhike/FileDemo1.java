package com.kaikeba.xinzhike;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
    public static void main(String[] args) {
        // File.separator表示系统分隔符，跨平台考虑
        File file = new File("c:" + File.separator + "an.txt");
        // 判断文件是否存在，如果存在则删除
        if (file.exists()) {
            file.delete();// 删除文件
            System.out.println("删除文件成功！");
        }
        try {
            file.createNewFile();//创建文件
            System.out.println("创建文件成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
