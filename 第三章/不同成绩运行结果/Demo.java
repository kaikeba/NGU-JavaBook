import java.util.Scanner;
// if语法演示
public class Demo {
    public static void main(String[] args) {
        // 准备程序中使用到的变量资源
        Scanner input = new Scanner(System.in);
        double score = 0;   // 用于存储成绩
        // 提示输入并接收成绩
        System.out.print("请输入成绩：");
        score = input.nextDouble();
        // 核心业务：进行判断后进行提示输出处理
        if (score <= 100 && score >= 90) {
            System.out.println("成绩优秀，不要骄傲！");
        } else if (score < 90 && score >= 80) {
            System.out.println("成绩良好，再接再厉！");
        } else if (score < 80 && score >= 60) {
            System.out.println("成绩中等，进步空间很大！");
        } else if (score < 60 && score >= 0) {
            System.out.println("成绩不及格，准备补考！");
        } else {
            System.out.println("你输入的是外星人的成绩吗？");
        }
        System.out.println("===成绩分级显示程序结束===");
    }
}

