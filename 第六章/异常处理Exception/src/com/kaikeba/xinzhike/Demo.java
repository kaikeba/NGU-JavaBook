package com.kaikeba.xinzhike;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎使用除法计算工具");
        try {
            System.out.println("请输入被除数");
            int x = input.nextInt();
            System.out.println("请输入除数");
            int y = input.nextInt();
            int z = 0;
            z = x / y;
            System.out.println("运算完毕，结果正在输出中");
            System.out.println("运算结果：" + z);
        } catch (Exception e) {
            System.out.println("产生了异常，已处理。程序可继续执行");
        }


        System.out.println("程序正常结束");
    }
}