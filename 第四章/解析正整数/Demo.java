import java.util.Scanner;
public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = 0, sum = 0;
        System.out.print("请输入5位数及以下的正整数");
        num = input.nextInt();
        if (num < 0 || num >= 100000) {	// 判断有效性
            System.out.println("范围超出，程序将退出");
            return;
        }
        while (num > 0) {
            int temp = num % 10;        // 获取个位数
            sum += temp;		// 进行累加
            num /= 10;			// 整除10
        }
        System.out.println("位数之和是：" + sum);
    }
}

