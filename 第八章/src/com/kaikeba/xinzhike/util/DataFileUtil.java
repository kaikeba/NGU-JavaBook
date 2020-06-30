package com.kaikeba.xinzhike.util;
import com.kaikeba.xinzhike.data.DataPool;
import java.io.*;
/**
 * 通过序列化、反序列化方式进行读取和保存
 */
public class DataFileUtil {
    // 存储的文件名为：xinzhike.familyBill
    private static File file = new File("xinzhike.familyBill");
    // 保存数据
    public static void save(DataPool dp) {
        ObjectOutputStream oos = null;
        try {
            if (file.exists())
                file.delete();
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(dp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // 读取加载数据
    public static DataPool load() {
        ObjectInputStream is = null;
        try {
            is = new ObjectInputStream(new FileInputStream(file));
            DataPool dp = (DataPool) is.readObject();
            return dp;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        }
        return null;
    }
}
