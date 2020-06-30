import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入交通指示灯颜色（红色、绿色、黄色）：");
        String color = input.next();
        switch (color) {
            default:
                System.out.println("无法识别的颜色");
                break;
            case "红色":
                System.out.println("红灯停");
                break;
            case "绿色":
                System.out.println("绿灯行");
                break;
            case "黄色":
                System.out.println("黄灯亮了等一等");
                break;

        }
        System.out.println("===请遵守交通法规===");
    }
}

