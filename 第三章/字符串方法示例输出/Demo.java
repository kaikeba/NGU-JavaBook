import java.util.Scanner;
public class Demo {
    public static void main(String[] args) {
        // 字符串前面有2个空格，中间有1个空格，后面有3个空格；长度15
        String str = "  abc123 abc   ";
        System.out.println("字符串str：" + str);			// 打印输出
        // 获得字符串的长度
        int len = str.length();
        System.out.println("字符串str长度：" + len);		// 打印15
        // 去掉字符串前后的空格
        String newStr = str.trim();
        System.out.println("字符串newStr：" + newStr);
        System.out.println("字符串newStr长度：" + newStr.length());// 打印10

    }
}
