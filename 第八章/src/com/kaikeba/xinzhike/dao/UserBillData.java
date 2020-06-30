package com.kaikeba.xinzhike.dao;
import com.kaikeba.xinzhike.bean.*;
import com.kaikeba.xinzhike.util.*;
import java.io.*;
import java.util.*;
/**
 * 一个账户信息对应的多个账单信息，也设置为可序列化
 */
    public class UserBillData implements Serializable {
    private User user;// 一个账户对象
    private ArrayList<Bill> data = new ArrayList<>();// 存储多个账单信息
    public UserBillData(User user) {
        this.user = user;
    }
    public User getUser() {
        return user;
    }
    /**
     * 添加账单
     * @param b
     */
    public void add(Bill b) {
        data.add(b);
    }
    /**
     * 获取登录者所有账单
     * @return
     */
    public ArrayList<Bill> findAll() {
        return data;
    }
    /**
     * 根据索引修改账单
     * @param index
     * @param newBill
     */
    public void update(int index, Bill newBill) {
        Bill oldBill = data.get(index);
        oldBill.setType(newBill.getType());
        oldBill.setMoney(newBill.getMoney());
        oldBill.setDescription(newBill.getDescription());
    }
    /**
     * 根据索引删除账单
     * @param index
     */
    public void remove(int index) {
        data.remove(index);
    }
    /**
     * 根据账单类型获取
     *
     * @param type
     * @return
     */
    public ArrayList<Bill> findByType(String type) {
        if ("所有账单".equals(type)) {
            return data;
        }
        ArrayList<Bill> typeData = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (type != null && type.equals(data.get(i).getType())) {
                typeData.add(data.get(i));
            }
        }
        return typeData;
    }
    /**
     * 根据时间区间获取
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    public ArrayList<Bill> findByDateInterval(Date start, Date end) {
        ArrayList<Bill> typeData = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            Date date = data.get(i).getDate();
            if (date.getTime() >= start.getTime() && date.getTime() <= end.getTime()) {
                typeData.add(data.get(i));
            }
        }
        return typeData;
    }
    /**
     * 根据日期获取
     * @param date 日期时间
     * @return
     */
    public ArrayList<Bill> findByDate(Date date) {
        ArrayList<Bill> typeData = new ArrayList<>();
        String ymd1 = DateFormatUtil.formatYMD(date);
        for (int i = 0; i < data.size(); i++) {
            String ymd2 = DateFormatUtil.formatYMD(data.get(i).getDate());
            if (ymd1.equals(ymd2)) {
                typeData.add(data.get(i));
            }
        }
        return typeData;
    }
}