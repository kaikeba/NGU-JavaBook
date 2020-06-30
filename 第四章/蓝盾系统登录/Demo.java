import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choose = 0; // 1）循环变量初始化
        while(choose != 3){ // 2）循环条件
            // 菜单显示，并接收选项
            System.out.println("* *欢迎使用蓝盾系统* *");
            System.out.println("* 1 登录            *");
            System.out.println("* 2 注册            *");
            System.out.println("* 3 退出            *");
            System.out.println("* * * * * * * * * * *");
            System.out.print("请选择（1~3）：");
            choose = input.nextInt();   // 3）循环变量值更新
            // 根据输入进行选择
            switch (choose){
                case 1:
                    System.out.println("===您选择了登录===");
                    break;
                case 2:
                    System.out.println("===您选择了注册===");
                    break;
                case 3:
                    System.out.println("===感谢使用，再见！===");

                    break;
                default:
                    System.out.println("---选择错误，请重新选择---");
                    break;
            }
        }

    }
}

