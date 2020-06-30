public class Demo {
    public static void main(String[] args) {
        int n1 = 1, n2 = 1, num = 0;
        // 先输出前3个数
        System.out.format("%-5d%-5d%-5d",0, n1, n2);
        for (int i = 0; i < 9; i++) {		// 输出后续的8个规律数
            num = n1 + n2;			// 获得前两个数之和，存入num
            n1 = n2;				// 前个数成为下一个数
            n2 = num;				// 下一个成为之前两数之和
            System.out.format("%-5d", num);	// 打印两数之和
        }
    }
}
