package com.kaikeba.xinzhike;

public class Demo  {
    // 主方法
    public static void main(String[] args) {
        ClassInfo ci = new ClassInfo(); // 创建班级对象
        ci.init();                      // 调用班级中初始化方法
        ci.showListAll();               // 显示所有学员
        // 修改班级中第二个学员(下标为1)的成绩为100分
        ci.getAll().get(1).setScore(100);
        System.out.println("---------------");
        // 输出查看
        ci.showListAll();
    }
}