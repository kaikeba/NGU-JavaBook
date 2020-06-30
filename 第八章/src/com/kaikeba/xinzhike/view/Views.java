package com.kaikeba.xinzhike.view;
import com.kaikeba.xinzhike.bean.*;
import com.kaikeba.xinzhike.dao.*;
import com.kaikeba.xinzhike.util.*;
import java.text.*;
import java.util.*;
/**
 * 菜单视图
 */
public class Views {
    //接收用户输入
    private Scanner input = new Scanner(System.in);
    public void welcome() {
        System.out.println("**********************\n" +
                "*  家庭记账系统 v1.0  *\n" +
                "**********************");
        System.out.println("--------欢迎使用-------");
        System.out.println("\t\t日事日毕，日增日高！\n");
    }
    // 初始化主账户信息
    public User initMainAccount() {
        welcome();
        System.out.println("首次使用请按照提示设置管理员信息");
        System.out.print("请输入管理员账号：");
        String nickName = input.next();
        System.out.print("请输入管理员密码：");
        String password = input.next();
        User u = new User(nickName, password);
        u.setManager(true);
        return u;
    }
    // 登录
    public User login() {
        System.out.println("---登录---");
        System.out.print("请输入账号：");
        String nickName = input.next();
        System.out.print("请输入密码：");
        String password = input.next();
        User u = new User(nickName, password);
        return u;
    }
    // 普通用户主菜单
    public int userClientMenu() {
        System.out.println("---账单管理---");
        System.out.println("1. 录入账单");
        System.out.println("2. 修改账单");
        System.out.println("3. 删除账单");
        System.out.println("4. 我的账单");
        System.out.println("0. 退出程序");
        System.out.print("请选择：");
        int num = -1;
        if (input.hasNextInt()) {
            num = input.nextInt();
        } else {
            input.next();
        }
        if (num < 0 || num > 4) {
            //当输入不合理时，重新输入
            System.out.println("输入有误！请重新操作！");
            return userClientMenu();
        }
        return num;
    }
    // 添加账单信息
    public Bill addBill() {
        System.out.println("---添加账单信息---");
        String type = null;
        Date date = new Date();
        String description = null;
        double money = 0.0;
        System.out.print("请输入账单类型(餐饮/购物/交通/娱乐/旅行/其他)：");
        type = input.next();
        while (true) {
            System.out.print("请输入账单金额：");
            if (input.hasNextDouble()) {
                money = input.nextDouble();
            } else {
                input.next();
            }
            if (money > 0.0) {
                break;
            } else {
                System.out.println("金额输入有误");
            }
        }
        System.out.print("请输入账单描述：");
        description = input.next();
        Bill b = new Bill(type, money, date, description);
        return b;
    }
    // 选择账单修改
    public int updateSelectBillIndex(ArrayList<Bill> data) {
        printBills(data);
        System.out.print("请观察上面的账单列表, 并输入要修改的账单序号：");
        int index = -1;
        while (true) {
            if (input.hasNextInt()) {
                index = input.nextInt();
            } else {
                input.next();
            }
            if (index < 0 || index >= data.size()) {
                System.out.print("输入有误,请重新输入要修改的账单序号：");
            } else {
                return index;
            }
        }
    }
    // 更新账单信息
    public Bill updateBill() {
        System.out.println("---更新账单信息---");
        String type = null;
        String description = null;
        double money = 0.0;
        System.out.print("请输入账单类型(餐饮/购物/交通/娱乐/旅行/其他)：");
        type = input.next();
        while (true) {
            System.out.print("请输入账单金额:");
            if (input.hasNextDouble())
                money = input.nextDouble();
            else
                input.next();
            if (money > 0.0) {
                break;
            } else {
                System.out.println("金额输入有误");
            }
        }
        System.out.println("请输入账单描述:");
        description = input.next();
        Bill b = new Bill(type, money, null, description);
        return b;
    }
    // 删除账单
    public int deleteSelectBillIndex(ArrayList<Bill> data) {
        printBills(data);
        System.out.print("---删除账单---");
        System.out.print("请选择要删除的账单序号：");
        int index = -1;
        while (true) {
            if (input.hasNextInt()) {
                index = input.nextInt();
            } else {
                input.next();
            }
            if (index < 0 || index >= data.size()) {
                System.out.print("输入有误,请重新输入要删除的账单序号：");
            } else {
                return index;
            }
        }
    }
    // 查看家庭成员信息
    public int printUserBillIndex(ArrayList<User> data) {
        printUsers(data);
        System.out.println("\t序号:-1\t查看其他家庭成员综合账单");
        System.out.println("请观察上面的成员列表, 并输入要查看的成员序号");
        System.out.print("输入-1表示家庭所有人员账单：");
        int index = -2;
        while (true) {
            if (input.hasNextInt()) {
                index = input.nextInt();
            } else {
                input.next();
            }
            if (index < -1 || index >= data.size()) {
                System.out.print("输入有误,请重新输入要删除的账单序号：");
            } else {
                return index;
            }
        }
    }
    // 印某个用户账单信息
    public void printUserBill(User u, ArrayList<Bill> data) {
        if (data == null || data.size() == 0) {
            System.out.println("家庭成员 " + u.getNickName() + " 无账单信息");
            return;
        }
        System.out.println("---------\t<" + u.getNickName() + ">的账单信息\t---------");
        printBills(data);
    }
    // 打印全部账单信息
    public void printAllBill(ArrayList<UserBillData> datas) {
        if (datas == null || datas.size() == 0) {
            System.out.println("暂无账单信息");
            return;
        }
        for (int i = 0; i < datas.size(); i++) {
            printUserBill(datas.get(i).getUser(), datas.get(i).findAll());
        }
    }
    // 用户选择账单类型
    public String printType() {
        w1:
        while (true) {
            System.out.println("---查看的账单类型---");
            System.out.println("\t1.餐饮\t2.购物\t3.交通");
            System.out.println("\t4.娱乐\t5.旅行\t6.其他\t0.所有账单");
            System.out.print("请选择：");
            String type = input.next();
            switch (type) {
                case "1":
                    return "餐饮";
                case "2":
                    return "购物";
                case "3":
                    return "交通";
                case "4":
                    return "娱乐";
                case "5":
                    return "旅行";
                case "6":
                    return "其他";
                case "0":
                    return "所有账单";
                default:
                    System.out.println("账单类型输入有误!");
            }
        }
    }
    // 打印所有账单详情，并进行汇总
    public void printBills(ArrayList<Bill> data) {
        if (data == null || data.size() == 0) {
            System.out.println("无账单信息");
            return;
        }
        double money = 0.0;
        for (int i = 0; i < data.size(); i++) {
            Bill b = data.get(i);
            String text = "序号 " + i + " , 信息如下:\n\r" +
                    "\t时间:" + DateFormatUtil.formatYMDHm(b.getDate()) +
                    "\n\r\t类型:" + b.getType() +
                    "\t金额:" + b.getMoney() +
                    "\n\r\t账单详情:" + b.getDescription();
            System.out.println(i + "" + data.get(i).toString());
            money += b.getMoney();
        }
        System.out.println("---------\t共消费了:" + money + "元\t---------\n\r");
    }
    // 选择查看账单方式
    public int printBillByTypeOrDate() {
        int m = -1;
        System.out.println("---选择查看账单方式---");
        while (true) {
            System.out.println("1.按类型查看\t\t2.按时间查看");
            System.out.print("请选择：");
            if (input.hasNextInt()) {
                m = input.nextInt();
            } else {
                input.next();
            }
            if (m < 1 || m > 2) {
                System.out.println("输入有误,请重新输入");
            } else {
                return m;
            }
        }
    }
    // 按日期查看
    public int printBillByDate() {
        int m = -1;
        System.out.println("---选择查看账单方式---");
        while (true) {
            System.out.println("1.查看某天账单\t\t2.查看某段时间账单");
            System.out.print("请选择：");
            if (input.hasNextInt()) {
                m = input.nextInt();
            } else {
                input.next();
            }
            if (m < 1 || m > 2) {
                System.out.println("输入有误,请重新输入");
            } else {
                return m;
            }
        }
    }
    // 某天账单查看
    public Date printBillByDay() {
        System.out.print("请输入查看的时间(格式: yyyy-MM-dd )：");
        String day = input.next();
        try {
            Date date = DateFormatUtil.toDateYMD(day);
            return date;
        } catch (ParseException e) {
            System.out.println("日期格式输入有误,请重新输入");
            return printBillByDay();
        }
    }
    // 某个时间段账单信息查看（开始日期）
    public Date printBillByStartDateInterval() {
        System.out.print("请输入开始日期(格式：yyyy-MM-dd)：");
        String day = input.next();
        try {
            Date date = DateFormatUtil.toDateYMD(day);
            return date;
        } catch (ParseException e) {
            System.out.println("日期格式输入有误,请重新输入");
            return printBillByStartDateInterval();
        }
    }
    // 某个时间段账单信息查看（结束日期）
    public Date printBillByEndDateInterval(Date start) {
        System.out.print("请输入结束时间(格式：yyyy-MM-dd):");
        String day = input.next();
        try {
            Date date = DateFormatUtil.toDateYMD(day);
            if (date.getTime() < start.getTime()) {
                System.out.println("结束时间必须大于等于开始时间");
                return printBillByEndDateInterval(start);
            }
            return date;
        } catch (ParseException e) {
            System.out.println("日期格式输入有误,请重新输入");
            return printBillByEndDateInterval(start);
        }
    }
    // 理员主菜单
    public int managerClientMenu() {
        System.out.println("---家庭记账系统---");
        System.out.println("1. 家庭成员管理");
        System.out.println("2. 录入账单");
        System.out.println("3. 修改账单");
        System.out.println("4. 删除账单");
        System.out.println("5. 我的账单");
        System.out.println("6. 查看其他成员账单");
        System.out.println("0. 退出程序");
        System.out.print("请选择：");
        int num = -1;
        if (input.hasNextInt()) {
            num = input.nextInt();
        } else {
            input.next();
        }
        if (num < 0 || num > 6) {
            //当输入不合理时，重新输入
            System.out.println("输入有误！请重新操作！");
            return managerClientMenu();
        }
        return num;
    }
    // 家庭成员管理菜单
    public int familyMenu() {
        System.out.println("---家庭成员管理---");
        System.out.println("1. 增加成员");
        System.out.println("2. 删除成员");
        System.out.println("3. 修改成员密码");
        System.out.println("4. 查看所有成员");
        System.out.println("0. 返回上层菜单");
        System.out.print("请选择：");
        int num = -1;
        if (input.hasNextInt()) {
            num = input.nextInt();
        } else {
            input.next();
        }
        if (num < 0 || num > 4) {
            //当输入不合理时，重新输入
            System.out.println("输入有误！请重新操作！");
            return familyMenu();
        }
        return num;
    }
    // 添加用户的视图
    public User addUser() {
        System.out.println("---增加成员---");
        System.out.println("请输入成员登录名：");
        String nickName = input.next();
        System.out.println("请输入密码：");
        String password = input.next();
        User u = new User(nickName, password);
        return u;
    }
    // 删除用户的视图
    public String removeUser() {
        System.out.print("请输入要删除的登录名：");
        String nickName = input.next();
        return nickName;
    }
    // 管理员修改用户密码
    public User updateUser() {
        System.out.println("---修改账户密码---");
        System.out.println("请输入要修改的登录名：");
        String nickName = input.next();
        System.out.println("请输入此帐户的新密码：");
        String password = input.next();
        User u = new User(nickName, password);
        return u;
    }
    // 查看所有用户
    public void printUsers(ArrayList<User> users) {
        if (users == null || users.size() == 0) {
            System.out.println("无用户信息");
            return;
        }
        System.out.println("\t家庭成员账号信息");
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            String text = "\t序号:" + i + "\t登录名: " + u.getNickName() +
                    "\t密码: " + u.getPassword();
            System.out.println(text);
        }
    }
    // 以下输出不同提示文本
    public void success() {
        System.out.println("操作成功!");
    }
    public void error() {
        System.out.println("操作失败!");
    }
    public void loginError() {
        System.out.println("登录名或密码错误,请检查!");
    }
    public void addUserError() {
        System.out.println("登录名已存在,添加失败");
    }
    public void updateUserError() {
        System.out.println("登录名不存在,修改失败");
    }
    public void removeUserError() {
        System.out.println("登录名不存在,删除失败");
    }
    public void welcomeUser(String nickName) {
        System.out.println("欢迎回来," + nickName);
    }
    public void welcomeManager(String nickName) {
        System.out.println("尊敬的管理员 " + nickName + " , 欢迎回来！");
    }
    public void bye() {
        System.out.println("程序退出，再见！");
    }
}