package com.kaikeba.xinzhike;

import java.io.Serializable;

// 学生类，是一个序列化类，实现Serializable接口
public class Student implements Serializable {
    private String name;
    private double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
}
