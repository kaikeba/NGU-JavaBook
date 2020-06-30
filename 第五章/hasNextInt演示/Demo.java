import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        if (input.hasNextInt()) {
            int num = input.nextInt();
            int result = num * num;
            System.out.println("该数的平方是：" + result);
        } else {
            System.out.println("输入错误！");
        }
    }
}
