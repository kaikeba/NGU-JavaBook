package com.kaikeba.xinzhike.main;
import com.kaikeba.xinzhike.bean.*;
import com.kaikeba.xinzhike.dao.*;
import com.kaikeba.xinzhike.data.*;
import com.kaikeba.xinzhike.util.*;
import com.kaikeba.xinzhike.view.*;
import java.util.*;
/**
 * 管理员菜单管理
 */
public class ManagerClient {
    private Views v;
    private DataPool dp;
    private UserBillData ubd;
    public ManagerClient(Views v, DataPool dp, UserBillData ubd) {
        this.v = v;
        this.dp = dp;
        this.ubd = ubd;
    }
    // 启动
    public void start() {
        v.welcomeUser(ubd.getUser().getNickName());
        while (true) {
            int key = v.managerClientMenu();
            switch (key) {
                case 1: {
                    //家庭成员管理
                    familyManager();
                    break;
                }
                case 2: {
                    //录入账单
                    Bill b = v.addBill();
                    ubd.add(b);
                    v.success();
                    break;
                }
                case 3: {
                    //修改账单
                    int index = v.updateSelectBillIndex(ubd.findAll());
                    Bill b = v.updateBill();
                    ubd.update(index, b);
                    v.success();
                    break;
                }
                case 4: {
                    //删除账单
                    int index = v.deleteSelectBillIndex(ubd.findAll());
                    ubd.remove(index);
                    v.success();
                    break;
                }
                case 5: {
                    //我的账单
                    int t = v.printBillByTypeOrDate();
                    if (t == 1) {
                        String type = v.printType();
                        ArrayList<Bill> data = ubd.findByType(type);
                        v.printBills(data);
                    } else {
                        int byDate = v.printBillByDate();
                        if (byDate == 1) {
                            Date date = v.printBillByDay();
                            ArrayList<Bill> data = ubd.findByDate(date);
                            v.printBills(data);
                        } else {
                            Date start = v.printBillByStartDateInterval();
                            Date end = v.printBillByEndDateInterval(start);
                            ArrayList<Bill> data = ubd.findByDateInterval(start, end);
                            v.printBills(data);
                        }
                    }
                    break;
                }
                case 6: {
                    //家庭成员账单
                    ArrayList<User> users = dp.findUsers();
                    int index = v.printUserBillIndex(users);
                    if (index == -1) {
                        ArrayList<UserBillData> datas = dp.getDatas();
                        v.printAllBill(datas);
                    } else {
                        User u = users.get(index);
                        UserBillData data = dp.getDatas().get(index);
                        v.printUserBill(u, data.findAll());
                    }
                    break;
                }
                case 0: {
                    //退出程序
                    v.bye();
                    System.exit(0);
                    break;
                }
            }
            switch (key) {
                case 2:
                case 3:
                case 4:
                    save();
                    break;
            }
        }
    }
    // 家庭成员管理
    private void familyManager() {
        while (true) {
            int key = v.familyMenu();

            switch (key) {
                case 1: {
                    //增加成员
                    User user = v.addUser();
                    boolean flag = dp.addUser(user);
                    if (flag) {
                        v.success();
                    } else {
                        v.addUserError();
                    }
                    break;
                }
                case 2: {
                    //删除成员
                    String nickName = v.removeUser();
                    boolean flag = dp.removeUser(nickName);
                    if (flag) {
                        v.success();
                    } else {
                        v.removeUserError();
                    }
                    break;
                }
                case 3: {
                    //修改成员密码
                    User u = v.updateUser();
                    boolean flag = dp.updateUser(u);
                    if (flag) {
                        v.success();
                    } else {
                        v.updateUserError();
                    }
                    break;
                }
                case 4: {
                    //查看所有成员
                    ArrayList<User> users = dp.findUsers();
                    v.printUsers(users);
                    break;
                }
                case 0: {
                    return;
                }
            }
            switch (key) {
                case 1:
                case 2:
                case 3:
                    //增删改时保存
                    save();
            }
        }
    }
    // 保存
    public void save() {
        DataFileUtil.save(dp);
    }
}