import java.util.Scanner;

public class Dialogue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String message = "";        // 用户存储消息
        String machine = "";        // 对话机器人名称
        System.out.print("请输入聊天对象昵称：");
        machine = input.next();
        System.out.println("** Java 人机交互模拟 **");
        while (true) {
            System.out.print("你：");
            message = input.next();
            if(message.equals("再见")){                               // 退出条件
                System.out.println(machine + "：跟你聊天很愉快，再见！");
                break;
            }
            message = message.replace("吗", "");    // 去掉句子中的“吗”
            message = message.replace("?", "!");    // 将英文输入法的问号替换为感叹号
            message = message.replace("？", "!");   // 将中文输入法的问好替换为感叹号
            System.out.println(machine + "：" + message);
        }
    }
}
