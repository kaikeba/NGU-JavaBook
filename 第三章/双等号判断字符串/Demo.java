import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("是否继续（yes | no）？");
        String choose = input.next();

        if (choose == "yes") {
            System.out.println("选择了yes");
        } else {
            System.out.println("选择了no");
        }
    }
}
