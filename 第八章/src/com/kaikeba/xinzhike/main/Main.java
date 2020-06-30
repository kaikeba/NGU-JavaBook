package com.kaikeba.xinzhike.main;
import com.kaikeba.xinzhike.bean.*;
import com.kaikeba.xinzhike.dao.*;
import com.kaikeba.xinzhike.data.*;
import com.kaikeba.xinzhike.util.*;
import com.kaikeba.xinzhike.view.*;
/**
 * 程序启动类
 */
public class Main {
    private static Views v;
    private static DataPool dp;
    private static UserBillData ubd;
    // 主方法
    public static void main(String[] args) {
        //初始化
        init();
        //欢迎
        v.welcome();
        //开始登录
        while (true) {
            login();
        }
    }
    // 登录
    private static void login() {
        User u = v.login();
        ubd = dp.login(u);
        //判断登录结果
        if (ubd == null) {
            //登录失败提示
            v.loginError();
        } else if (ubd.getUser().isManager()) {
            //管理员登录成功
            ManagerClient client = new ManagerClient(v, dp, ubd);
            //启动管理员客户端
            client.start();
        } else {
            //其他家庭成员登录成功
            UserClient client = new UserClient(v, dp, ubd);
            //启动家庭成员客户端
            client.start();
        }
    }
    // 初始化
    private static void init() {
        //初始化视图对象
        v = new Views();
        //加载本地文件
        dp = DataFileUtil.load();
        //如果加载失败, 表示第一次使用, 进行初始化
        if (dp == null) {
            dp = new DataPool();
            User user = v.initMainAccount();
            dp.init(user);
            v.success();
            DataFileUtil.save(dp);
        }
    }
}
