public class Demo {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.format("%d*%d=%-4d", j, i, (i * j));        // 注意格式
            }
            System.out.println();
        }

    }
}
