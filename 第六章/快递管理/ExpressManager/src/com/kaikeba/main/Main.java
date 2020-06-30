package com.kaikeba.main;

import com.kaikeba.bean.Express;
import com.kaikeba.control.ExpressControl;
import com.kaikeba.view.Views;

import java.util.List;

/**
 * 程序的入口类
 @author liweijie
 */
public class Main {
    public static void main(String[] args) {
        //创建视图对象
        Views view = new Views();
        //创建功能对象
        ExpressControl control = new ExpressControl();
        //欢迎界面
        view.welcome();
        //循环执行主菜单和后续流程
        m:while(true){
            //显示主菜单
            int menu = view.mainMenu();
            //根据用户选择的主菜单内容，进行相应操作
            switch (menu){
                case 0:
                    //当用户输入m时，结束主流程循环
                    break m;
                case 1:{
                    //录入快递的视图
                    Express express = view.inMenu();
                    //将接收到用户输入的快递信息，传递给control进行存储
                    control.addExpress(express);
                    break;
                }
                case 2: {
                    //取出快递的视图，会提示用户输入取件码
                    int extractionCode = view.outMenu();
                    //根据用户输入的取件码，从control中取出快递数据
                    Express express = control.getExpress(extractionCode);
                    //将取出的快递数据进行显示
                    view.printExpress(express);
                    break;
                }
                case 3:{
                    //从control中取出所有快递
                    List<Express> data = control.findAll();
                    //将所有快递输出显示
                    view.printAll(data);
                    break;
                }
            }
        }
        //再见界面
        view.bye();
    }
}
