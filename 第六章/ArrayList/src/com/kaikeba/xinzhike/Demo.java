package com.kaikeba.xinzhike;
import java.util.ArrayList;
public class Demo {
    public static void main(String[] args) {
        // 创建泛型集合对象
        ArrayList<Integer> list = new ArrayList<Integer>();
        // 增加元素
        list.add(55);
        list.add(23);
        list.add(99);
        // 循环输出
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        // 修改第一个元素为100
        list.set(0,100);
        // 删除第二个元素
        list.remove(1);
        System.out.println("-----------");
        // 循环输出
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}