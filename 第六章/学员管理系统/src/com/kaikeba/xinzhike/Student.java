// 学生类Student.java
package com.kaikeba.xinzhike;
// 学生类
public class Student {
    private int no;         // 学号
    private String name;    // 姓名
    private double score;   // 成绩

    public Student(int no, String name, double score) {
        this.no = no;
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
