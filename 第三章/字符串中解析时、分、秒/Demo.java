import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        String str = "12:05:20";
        // 截取小时、分钟和秒
        String hhStr = str.substring(0, 2); // 截取小时部分
        System.out.println("时：" + hhStr);   // 打印小时
        String mmStr = str.substring(3, 5);
        System.out.println("分：" + mmStr);   // 打印分钟
        String ssStr = str.substring(6, 8);
        System.out.println("秒：" + ssStr);   // 打印秒
        // 将字符串转换为整型，方便参与运算
        int hh = Integer.parseInt(hhStr);
        int mm = Integer.parseInt(mmStr);
        int ss = Integer.parseInt(ssStr);
        int ssTot = ss + (mm * 60) + (hh * 60 * 60);    // 总秒数
        System.out.println(str + "一共是" + ssTot + "秒");
    }
}
