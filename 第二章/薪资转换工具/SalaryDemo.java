import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * 薪资转换工具v1.0
 * @author Andy
 */
public class SalaryDemo {
    public static void main(String[] args) {
        // 提示并接收用户输入月薪
        System.out.println("***薪资转换工具v1.0***");
        System.out.print("请输入月薪（人民币）：");
        Scanner input = new Scanner(System.in);
        double mSalary = input.nextDouble(); // 接收月薪
        // 进行业务处理
        double mDay = mSalary / 22;           // 每月22个工作日
        double mYear = mSalary * 13;          // 一年发放13月工资
        // 格式化输出
        DecimalFormat df = new DecimalFormat("￥###,###.00");
        System.out.format("您的日薪：￥%-10.2f%n" ,mDay);
        System.out.println("您的年薪：" + df.format(mYear) );
    }
}

