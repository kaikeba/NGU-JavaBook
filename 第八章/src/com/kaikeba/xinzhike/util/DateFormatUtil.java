package com.kaikeba.xinzhike.util;
import java.text.*;
import java.util.*;
/**
 * 数据格式化工具类（年-月-日）
 */
public class DateFormatUtil {
    private static SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat ymdhm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static String formatYMD(Date date) {
        return ymd.format(date);
    }
    public static Date toDateYMD(String date) throws ParseException {
        return ymd.parse(date);
    }
    public static String formatYMDHm(Date date) {
        return ymdhm.format(date);
    }
    public static Date toDateYMDHm(String date) throws ParseException {
        return ymdhm.parse(date);
    }
}