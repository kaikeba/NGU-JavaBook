import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 用户名和密码输入验证，最多尝试三次
        for (int i = 0; i < 3; i++) { // 循环三次，控制最多尝试次数
            System.out.print("用户名：");
            String name = input.next();
            System.out.print("密码：");
            String pwd = input.next();
            if (name.equals("kkb") && pwd.equals("4009960826")) {
                System.out.println(name + "，登录成功！");
                break;      // 用户名和密码输入正确，退出循环
            } else {
                System.out.println("用户名或密码错误！");
                System.out.println("你还有" + (2 - i) + "次机会！");
            }
        }
    }
}

