package com.kaikeba.xinzhike.main;
import com.kaikeba.xinzhike.bean.*;
import com.kaikeba.xinzhike.dao.*;
import com.kaikeba.xinzhike.data.*;
import com.kaikeba.xinzhike.view.*;
import com.kaikeba.xinzhike.util.*;
import java.util.*;
/**
 * 家庭用户账单管理
 */
public class UserClient {
    private Views v;
    private DataPool dp;
    private UserBillData ubd;
    // 构造方法
    public UserClient(Views v, DataPool dp, UserBillData ubd) {
        this.v = v;
        this.dp = dp;
        this.ubd = ubd;
    }
    // 启动菜单
    public void start() {
        v.welcomeUser(ubd.getUser().getNickName());
        while (true) {
            int key = v.userClientMenu();
            switch (key) {
                case 1: {
                    //录入账单
                    Bill b = v.addBill();
                    ubd.add(b);
                    v.success();
                    break;
                }
                case 2: {
                    //修改账单
                    int index = v.updateSelectBillIndex(ubd.findAll());
                    Bill b = v.updateBill();
                    ubd.update(index, b);
                    v.success();
                    break;
                }
                case 3: {
                    //删除账单
                    int index = v.deleteSelectBillIndex(ubd.findAll());
                    ubd.remove(index);
                    v.success();
                    break;
                }
                case 4: {
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
                case 0: {
                    //退出程序
                    v.bye();
                    System.exit(0);
                }
            }
            switch (key) {
                case 1:
                case 2:
                case 3:
                    //增删改保存到本地
                    save();
                    break;
            }
        }
    }
    // 保存
    public void save() {
        DataFileUtil.save(dp);
    }
}