import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {    // 条件设置为死循环
            System.out.print("请问，我是最帅的吗？");
            String str = input.next();
            if (str.equals("是")) {    // 符合条件再退出循环
                System.out.println("真有眼光！有缘再见！");
                break;
            }
        }

    }
}

