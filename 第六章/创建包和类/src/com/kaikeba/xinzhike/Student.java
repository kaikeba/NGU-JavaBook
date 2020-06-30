package com.kaikeba.xinzhike;
// 学生类
public class Student {
    public String name; // 学员姓名
    // 自我介绍
    public String introduce() {
        int result = add(6,7);  // 类内部调用（测试）
        System.out.println("先做一个数学题，答案是：" + result);
        return String.format("大家好，我是%s，很高兴认识大家！", name);
    }
    public int add(int n1,int n2){
        return  n1 + n2;
    }
    // 计算阶乘
    public int factorial(int n) {
        return n == 1 ? 1 : n * factorial((n - 1));
    }
}
