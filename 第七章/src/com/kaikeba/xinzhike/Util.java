package com.kaikeba.xinzhike;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
// 加密解密程序
public class Util {
    public static void main(String[] args) throws Exception {
        System.out.println("请输入文件要处理文件的全路径:");
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();
        //原文件	:	xzk_logo.png
        File oldFile = new File(fileName);
        //加密存储的新文件	pwd-xzk_logo.png
        File newFile = new File(oldFile.getParentFile(),"pwd-"+oldFile.getName());

        FileInputStream fis = new FileInputStream(oldFile);
        FileOutputStream fos = new FileOutputStream(newFile);
        while(true) {
            int b = fis.read();
            if(b == -1) {
                break;
            }
            //任何数据^相同的数字两次 结果就是其本身
            fos.write(b^10);
        }
        // 关闭源文件IO流
        fos.close();
        fis.close();
        if(oldFile.delete()){   // 删除源文件
            System.out.println("源文件已删除！");
        }
        System.out.println("新文件加密或解密完成！");
    }
}
