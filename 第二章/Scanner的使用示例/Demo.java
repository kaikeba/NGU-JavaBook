// 第一步，通过导入包指定Scanner类
import java.util.Scanner;
public class Demo {
    public static void main(String[] args) {
        // 第二步，创建Scanner的对象input，以后用input就可以
        Scanner input = new Scanner(System.in);
        // 第三步，通过input对象引用不同方法接收用户输入
        System.out.print("请输入姓名：");	// 首先进行提示，注意输出后没有换行
        String name = input.nextLine();		// 接收用户输入的一行信息（字符串类型）存入name
        System.out.print("请输入成绩：");	// 第二个提示
        double score = input.nextDouble();	// 接收用户输入的成绩（double类型），存入score
        // 验证输出
        System.out.println(name + "，您好！您的成绩是：" + score);
    }
}

