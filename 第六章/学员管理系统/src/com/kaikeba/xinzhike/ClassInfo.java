// 班级类ClassInfo.java
package com.kaikeba.xinzhike;

import java.util.ArrayList;
// 班级类
public class ClassInfo {
    //班级中存放所有学员的容器
    private ArrayList<Student> stuList = new ArrayList<Student>();

    // 初始化学员信息到stuList集合中
    public  void init(){
        Student s1 = new Student(1001,"孙悟空",98);
        Student s2 = new Student(1002,"猪八戒",88);
        Student s3 = new Student(1003,"沙和尚",80);
        // 添加到集合
        stuList.add(s1);
        stuList.add(s2);
        stuList.add(s3);
    }

    public ArrayList<Student> getAll(){
        return stuList;
    }

    public void showListAll(){
        System.out.println("---学员列表---");
        System.out.println("学号\t\t姓名\t\t成绩");
        for(int i = 0;i < stuList.size();i++){
            // 注意：stuList.get(i)返回一个Student对象，可以继续通过点（.）调用公共方法
            System.out.format("%d\t\t%s\t\t%.2f%n",
                    stuList.get(i).getNo(),
                    stuList.get(i).getNo(),
                    stuList.get(i).getScore()
            );
        }
    }
}
