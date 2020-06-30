package com.kaikeba.xinzhike;
public class Demo {
    // 程序入口
    public static void main(String[] args) {
        //创建人的对象，并给对象命名为p
        Person p = new Person();
        //设置对象p的姓名为小明
        p.name = "小明";
        //p.age = -999;//p.age的方式无法使用，提示错误信息：age has private access in "Person"
        //设置对象p的年龄为-999
        p.setAge(-999);
        //调用对象p的说话方法
        p.say();
    }
}