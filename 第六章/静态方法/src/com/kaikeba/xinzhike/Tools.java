package com.kaikeba.xinzhike;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {
    /**
     * 按照年月日格式返回当前日期
     * @return String
     */
    public  static String getFormatNow() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }
}
