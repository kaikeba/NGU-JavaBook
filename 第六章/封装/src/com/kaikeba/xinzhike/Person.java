package com.kaikeba.xinzhike;

class Person {
    //姓名
    String name;
    //年龄
    private int age;
    public void setAge(int age2) {
        if (age2 < 0 || age2 > 150) {
            age = 1;
            System.out.println("age设置不合理，已自动修正为默认值1");
        } else {
            age = age2;
        }
    }
    //说话的功能方法
    void say() {
        System.out.println("我是" + name + "，我今年" + age + "岁了");
    }
}
