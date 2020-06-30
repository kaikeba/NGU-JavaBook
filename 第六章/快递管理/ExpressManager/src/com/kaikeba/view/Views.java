package com.kaikeba.view;
import com.kaikeba.bean.Express;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * 视图类, 用于与用户交互( 显示视图和接收用户输入 )
 */
public class Views {
    //接收用户输入的对象
    private Scanner input = new Scanner(System.in);
    //随机数对象， 用于随机生成取件码
    private Random random = new Random();

    /**
     * 欢迎界面
     */
    public void welcome(){
        System.out.println("欢迎使用小区快递管理系统");
    }
    /**
     * 再见界面
     */
    public void bye(){
        System.out.println("程序即将关闭，再见 ~");
    }

    /**
     * 主菜单界面
     * @return 返回的是用户选择的序号
     */
    public int mainMenu(){
        System.out.println("请根据提示，输入功能序号：");
        System.out.println("1. 快递录入");
        System.out.println("2. 快递取出");
        System.out.println("3. 查看所有");
        System.out.println("0. 退出程序");
        int num = -1;
        try {
            num = input.nextInt();
        }catch(Exception e){
            //当发生异常时，表示42行未执行成功，也就是说num还是默认值-1。
            //-1的num会进入下面的if语句，提示用户重新输入
        }
        if(num<0 || num>3){
            //当输入不合理时，重新输入
            System.out.println("输入有误！请重新操作！");
            return mainMenu();
        }
        return num;
    }

    /**
     * 录入快递权限验证界面
     * @return 返回的是用户输入的权限密码
     */
    private boolean inputPassword(){
        System.out.println("请输入权限密码：（输入错误回上层目录）");
        String password = input.next();
        //内置密码123456 , 计算对比结果
        boolean result = "123456".equals(password);
        return result;
    }

    /**
     * 录入快递界面
     * @return 返回的是录入时输入的快递信息
     */
    public Express inMenu(){
        System.out.println("请根据提示进行快递录入:");
        System.out.println("请输入快递公司：");
        String company = input.next();
        System.out.println("请输入快递单号：");
        String expressNumber = input.next();
        System.out.println("请输入收件人手机号码：");
        String phoneNumber = input.next();
        //将输入的快递内容组装为一个快递对象
        Express e = new Express();
        e.setCompany(company);
        e.setNumber(expressNumber);
        e.setPhoneNumber(phoneNumber);
        return e;
    }

    /**
     *取件界面
     * @return 返回的是用户输入的取件码
     */
    public int outMenu(){
        System.out.println("请输入您的六位数字取件码：");
        int code = -1;
        try {
            code = input.nextInt();
        }catch(Exception e){
            //如果产生异常， 则code是默认值-1. 后续有判断<100000的处理
        }
        if(code<100000 || code>999999){
            System.out.println("输入有误！");
            return outMenu();
        }
        return code;
    }

    /**
     * 用于显示取件的快递信息
     * @param e 用于显示的快递对象
     */
    public void printExpress(Express e){
        if(e == null){
            System.out.println("取件码不存在。即将回到主界面");
        }else{
            System.out.println("取件成功：");
            System.out.println("快递公司："+e.getCompany()+"，快递单号："+e.getNumber()+",收件人手机号码："+e.getPhoneNumber()+"，取件码："+e.getExtractionCode());
        }
    }

    /**
     * 用于显示所有快递的视图方法
     * @param data
     */
    public void printAll(List<Express> data){
        if(data.size() == 0){
            System.out.println("暂无快递，即将回到主界面");
        }else{
            System.out.println("快递信息如下：");
            for (int i=0;i<data.size();i++){
                Express e = data.get(i);
                System.out.println("快递公司："+e.getCompany()+"，快递单号："+e.getNumber()+",收件人手机号码："+e.getPhoneNumber()+"，取件码："+e.getExtractionCode());
            }
            //此时因为需要浏览输出的快递信息， 所以等待任意键后 再继续操作
            System.out.println("快递信息显示完毕， 即将回到主页");
        }
    }
}
