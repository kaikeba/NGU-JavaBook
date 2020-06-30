import java.util.Scanner;
public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 声明并定义数组
        double[] score = new double[3];
        // 循环接收用户输入，注意循环不要导致数组越界
        for (int i = 0; i < 3; i++) {
            System.out.format("请输入第%d个成绩：", (i + 1));
            score[i] = input.nextDouble();  // 通过索引赋值
        }
        // 循环输出
        System.out.println("输入的成绩如下：");
        for (int i = 0; i < 3; i++) {
            System.out.println(score[i]);   // 通过索引取值
        }
    }
}
