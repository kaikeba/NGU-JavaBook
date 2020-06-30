package com.kaikeba.xinzhike;
import java.util.Random;
public class Demo {
    public static void main(String[] args) {
        // 声明随机数对象
        Random random = new Random();
        // 获取0到9（不包括9）之间的随机数
        int n = random.nextInt(9);
        System.out.println(n);// 打印输出
    }
}