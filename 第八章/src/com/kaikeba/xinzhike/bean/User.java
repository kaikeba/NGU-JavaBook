package com.kaikeba.xinzhike.bean;
import java.io.*;
/**
 *  用户信息，设置为可序列化，用于保存到文件
 */
public class User implements Serializable {
    private String nickName;// 昵称
    private String password;// 密码
    private boolean manager;// 是否是管理员
    public User(String nickName, String password, boolean manager) {
        this.nickName = nickName;
        this.password = password;
        this.manager = manager;
    }
    public User(String nickName, String password) {
        this.nickName = nickName;
        this.password = password;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isManager() {
        return manager;
    }
    public void setManager(boolean manager) {
        this.manager = manager;
    }
    // 用于输出定制化类消息
    public String toString() {
        return "家庭成员登录名: " + nickName +
                "\t\t家庭成员密码: " + password;
    }
}