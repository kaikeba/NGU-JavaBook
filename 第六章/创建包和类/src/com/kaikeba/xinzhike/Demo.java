package com.kaikeba.xinzhike;
public class Demo {
    // 程序入口
    public static void main(String[] args) {
        // 创建对象
        Student s1 = new Student();
        s1.name = "张三丰";
        // 通过对象调用无参数方法
        // 通过对象调用无参数方法
//      String str = s1.introduce();
//      System.out.println(str);
//
//      int result = s1.add(5,3);
//      System.out.println(result);

        int result = s1.factorial(4);
        System.out.println(result);
    }
}